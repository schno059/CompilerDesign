import java.util.*;
import java.lang.Math;

/**
 * AST node for a program
 */ 
class ProgramAST implements AST {
  IdentAST ident;
  MembersAST members;
  static Node root, symbolTable;

  public ProgramAST() {
    symbolTable = new Node();
    root = symbolTable;
  }

  public ProgramAST(IdentAST i, MembersAST m) {
  	ident = i;
  	members = m;
    symbolTable = new Node();
    root = symbolTable;
  }

  public void checkSymbolTable()
  {
    System.out.println("\n\n--------[Type Verification]--------\n\n");
    declare(""+ident,"class");
    enterScope();
    members.checkSymbolTable();
    exitScope();
    System.out.println("\n\n--------[Final Symbol Table]--------\n");
    System.out.println(root);
  }

  public void declare(String var, String type)
  {
    if(hasBeenDeclaredLocally(var))
      throw new MultipleDeclarationException("Variable \'"+var+"\' has already been declared as type "+getType(var));
    else
      symbolTable.declare(var,type.toUpperCase());
  }

  public String use(AST var)
  {
    if(hasBeenDeclared(""+var))
      return symbolTable.use(root, ""+var);
    else
      throw new VariableUndeclaredException("Variable \'"+var+"\' has not been declared in the local or enclosing scopes");
  }

  public void enterScope()
  {
    symbolTable = symbolTable.enterScope();
  }

  public void exitScope()
  {
    symbolTable = symbolTable.exitScope(root);
  }

  public void validateAssignment(NameAST name, ExprAST expression)
  {
    String n = name.typeCheck();
    String e = expression.typeCheck();

    if(n.substring(0, Math.min(n.length(), 6)).equals("FINAL_"))
      finalReassign(name);
    else if(n.equals("FLOAT"))
      if(e.equals("FLOAT")||e.equals("INT"))
        System.out.println("\'"+name+"\' is of type "+n+". \'"+expression+"\' is of type "+e+". --> OK");
      else
        typeMismatch(expression, name, "FLOAT, INT");
    else if(n.equals("BOOL"))
      if(e.equals("BOOL")||e.equals("INT"))
        System.out.println("\'"+name+"\' is of type "+n+". \'"+expression+"\' is of type "+e+". --> OK");
      else
        typeMismatch(expression, name, "BOOL, INT");
    else
      if(n.equals(e))
        System.out.println("\'"+name+"\' is of type "+n+". \'"+expression+"\' is of type "+e+". --> OK");
      else
        typeMismatch(expression, name, n);
  }

  public String validateMethodCall(IdentAST ident, ArgsAST args)
  {
    String actual = use(ident);
    // int index = actual.indexOf(")_")+2;
    String returnType = "";
    if(actual.contains(")_"))
      returnType = actual.substring(actual.indexOf(")_")+2, actual.length());
    actual = actual.substring(4, actual.indexOf(")"));
    // String returnType = actual.substring(0, actual.length());
    // actual = actual.substring(0, actual.length());

    String call;
    if(args!=null)
      call = args.typeCheck();
    else
      call = "";

    //System.out.println(call);

    String[] actualList = actual.split("[,]", 0);
    String[] callList = call.split("[,]", 0);
    
    if(actualList.length!=callList.length)
      methodArgMismatch("Method "+ident+" called with incorrect number of arguments");
    else if(!coercivelyEquals(actualList, callList))
      methodArgMismatch("\'"+ident+"()\' called with arguments ["+call+"] which are not coercible to ["+actual+"]");
      // System.out.println(actual);
    else
      System.out.println("\'"+ident+"()\' takes in ["+actual+"]. \'"+args+"\' are of types ["+call+"] respectively. --> OK");
    return returnType;
  }

  private boolean coercivelyEquals(String[] firstList, String[] secondList)
  {
    boolean returnVal = true;
    for(int i=0; i<firstList.length; i++)
      if(!coercivelyEquals(firstList[i], secondList[i]))
        returnVal = false;
    return returnVal;
  }

  public boolean coercivelyEquals(String n, String fe)
  {
    String e = fe;
    if(fe.length()>=6 && fe.substring(0, 6).equals("FINAL_"))
      e = fe.substring(6, fe.length());
    if(n.equals("FLOAT"))
      if(e.equals("FLOAT")||e.equals("INT"))
        return true;
      else
        return false;
    else if(n.equals("BOOL"))
      if(e.equals("BOOL")||e.equals("INT"))
        return true;
      else
        return false;
    else
      if(n.equals(e))
        return true;
      else
        return false;
  }

  public void returnTypeMismatch(TypeAST type, IdentAST ident, String receivedType)
  {
    throw new TypeMismatchException("Incorrect return statement. Tried to return "+receivedType+" on \'"+ident+"()\'. Acceptable types are ["+type.toString().toUpperCase()+"]");
  }

  public void noReturnType(TypeAST type, IdentAST ident)
  {
    throw new TypeMismatchException("\'"+ident+"()\' has no return statement. Expected to return type "+type.toString().toUpperCase());
  }

  public void ifMismatch(ExprAST e)
  {
    throw new TypeMismatchException("Incorrect if-statement. \'"+e+"\' is of type "+e.typeCheck()+". Acceptable types are [BOOL, INT]");
  }

  public void whileMismatch(ExprAST e)
  {
    throw new TypeMismatchException("Incorrect while-statement. \'"+e+"\' is of type "+e.typeCheck()+". Acceptable types are [BOOL, INT]");
  }

  private void typeMismatch(AST value, NameAST variable, String acceptableTypes)
  {
    throw new TypeMismatchException("Attempted to assign \'"+value+"\' to variable \'"+variable+"\'. Acceptable types are ["+acceptableTypes+"]");
  }

  public void typeMismatch(String s)
  {
    throw new TypeMismatchException(s);
  }

  private void methodArgMismatch(String s)
  {
    throw new MethodArgMismatchException(s);
  }

  private void finalReassign(NameAST name)
  {
    throw new FinalReassignException("Attempted to change the value of \'"+name+"\' which is a final variable");
  }

  private String getType(String var)
  {
    return symbolTable.getType(root, var);
  }

  private boolean hasBeenDeclared(String var)
  {
    return ((root!=null) && (symbolTable.getType(root, var) != null));
  }

  private boolean hasBeenDeclaredLocally(String var)
  {
    return ((root!=null) && (symbolTable.getLocalType(var) != null));
  }

  public String toString() {
  	if(ident==null)
  		return("");
  	else
    	return("class "+ident+" {"+members+"};");
  }

}

