
/**
 * AST node for argument declarations
 */ 
class ArgDeclsAST extends StmtAST implements AST {
  ArgDeclAST arg;
  ArgDeclsAST args;

  public ArgDeclsAST() {}

  public ArgDeclsAST(ArgDeclAST a) {
    arg = a;
  }

  public ArgDeclsAST(ArgDeclAST a, ArgDeclsAST s) {
    arg = a;
    args = s;
  }

  public void checkSymbolTable()
  {
    if(arg!=null)
      arg.checkSymbolTable();
    if(args!=null)
      args.checkSymbolTable();
  }

  public String typeCheck()
  {
    if(arg==null)
      return("");
    else if (args == null)
      return(""+arg.typeCheck());
    else
      return(""+arg.typeCheck()+","+args.typeCheck());
  }

  public String toString() {
    if(arg==null)
      return("");
    else if (args == null)
      return(""+arg);
    else
      return(""+arg+", "+args);
  }

}


