
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

  public String toString() {
    if(arg==null)
      return("");
    else if (args == null)
      return(""+arg);
    else
      return(""+arg+", "+args);
  }

}


