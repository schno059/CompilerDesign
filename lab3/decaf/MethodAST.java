/**
 * AST node for method
 */ 
class MethodAST extends MethodsAST implements AST {
  TypeAST type;
  IdentAST ident;
  ArgDeclsAST args;
  FieldsAST fields;
  StmtsAST stmts;
  OptSemiAST optsemi;

  public MethodAST(IdentAST i, ArgDeclsAST a, FieldsAST f, StmtsAST s, OptSemiAST o) {
  	ident = i;
  	args = a;
  	fields = f;
  	stmts = s;
  	optsemi = o;
  }

  public MethodAST(TypeAST t, IdentAST i, ArgDeclsAST a, FieldsAST f, StmtsAST s, OptSemiAST o) {
  	type = t;
  	ident = i;
  	args = a;
  	fields = f;
  	stmts = s;
  	optsemi = o;
  }

  public void checkSymbolTable()
  {
    if(type==null)
      declare(""+ident,"fn_("+args.typeCheck()+")_void");
    else
      declare(""+ident,"fn_("+args.typeCheck()+")_"+type);
    enterScope();
    if(args!=null)
      args.checkSymbolTable();
    if(fields!=null)
      fields.checkSymbolTable();
    if(stmts!=null)
    {
      stmts.checkSymbolTable();
      if(type==null)
      {
        if(stmts.typeCheck().equals("VOID"))
          System.out.println("\'"+ident+"()\' is VOID. Returns type "+stmts.typeCheck()+". --> OK");
        else if(stmts.typeCheck().equals(""))
          System.out.println("\'"+ident+"()\' is VOID. Has no return statement. --> OK");
        else
          returnTypeMismatch(type, ident, stmts.typeCheck());
      }
      else
      {
        if(stmts.typeCheck().equals(""))
          noReturnType(type, ident);
        else if(coercivelyEquals(type.toString().toUpperCase(), stmts.typeCheck()))
          System.out.println("\'"+ident+"()\' is of type "+type.toString().toUpperCase()+". Returns type "+stmts.typeCheck()+". --> OK");
        else
          returnTypeMismatch(type, ident, stmts.typeCheck());
      }
    }
    exitScope();
  }

  public String toString() {
  	if(type==null)
  		return("void "+ident+"("+args+") {\n\n"+fields+""+stmts+"\n\n} "+optsemi);
  	else
    	return(""+type+" "+ident+"("+args+") {\n\n"+fields+""+stmts+"\n\n} "+optsemi);
  }

}

