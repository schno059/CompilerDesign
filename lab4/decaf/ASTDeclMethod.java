import java.util.*;

class ASTDeclMethod extends ASTDecl {

  Integer typeNum;
  String methodName;
  ArrayList<ASTDeclArg> argDecls;
  String typeName;
  ASTStmtCodeBlock methodBody;

  private ASTDeclMethod() {}

  public ASTDeclMethod(Integer tnum, String mname, ArrayList<ASTDeclArg> args, ASTStmtCodeBlock b) {
    typeNum = tnum;
    methodName = mname;
    argDecls = args;
    typeName = null;
    methodBody = b;
  }

  public ASTDeclMethod(String tName, String mname, ArrayList<ASTDeclArg> args, ASTStmtCodeBlock b) {
    typeNum = null;
    methodName = mname;
    argDecls = args;
    typeName = tName;
    methodBody = b;
  }

  public String toString(int indent) {
    String result = "" + AST.indentString(indent) + ((typeNum == null) ? typeName : sym.terminalNames[typeNum].toLowerCase()) + " " + methodName + " (";
    
    for (int i = 0; i < argDecls.size(); i++) {
      result += argDecls.get(i).toString();
      if (i < (argDecls.size()-1)) result += ", ";
    }
    result += ")\n" + methodBody.toString(indent+1);
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    SymbolTable.enterScope();
    Type returnType = null;
    if (typeName == null) {
      returnType = new TypeBase(typeNum);
    }
    else {
      STEntry findSTE = SymbolTable.findName(typeName + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Unable to find class " + typeName + " for return type of method " + methodName + "(looking for " + typeName + SymbolTable.CLASS_EXTENSION + ")");
        returnType = new TypeError();
      }
      else {
        returnType = new TypeClass(typeName,findSTE);
      }
    }
    ArrayList<Type> argTypes = new ArrayList<Type>();
    for (ASTDeclArg arg : argDecls) {
      argTypes.add(arg.processNamesTypeCheck());
    }
    TypeMethod methodType = new TypeMethod(returnType,argTypes);
    STEntry newSTE = new STMethodDeclEntry(methodName + SymbolTable.METHOD_EXTENSION,methodType,methodBody.stmts,SymbolTable.topTable);
    SymbolTable.setCurrentMethod((STMethodDeclEntry) newSTE);
    if (!SymbolTable.insertNameIntoEnclosingScope(methodName + SymbolTable.METHOD_EXTENSION,newSTE)) {
      SymbolTable.reportError("Method " + methodName + " multiply declared");
    }
    for (ASTDecl decl : methodBody.decls)
      decl.processNames();
    
    for (ASTStmt stmt : methodBody.stmts)
      stmt.processNames();
    SymbolTable.clearCurrentMethod();
    SymbolTable.exitScope();
  }

  public void run() {
    // System.out.println("METHOD DECLARATION RUNNING");
    for(ASTDeclArg arg : argDecls) arg.run();
  }

  public boolean isMainMethod() {
    return (methodName.equals("main") && typeNum == 38 && argDecls.size()==0);
  }

  public void call() {
    // System.out.println("CALLED "+methodName);
    methodBody.run();
  }

}
