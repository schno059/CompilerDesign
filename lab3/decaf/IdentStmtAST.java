
/**
 * AST node for identifier statements
 */ 
class IdentStmtAST extends StmtAST implements AST {
  IdentAST ident;
  ArgsAST args;

  public IdentStmtAST(IdentAST i) {
    ident = i;
  }

  public IdentStmtAST(IdentAST i, ArgsAST a) {
    ident = i;
    args = a;
  }

  public void checkSymbolTable()
  {
    if(args!=null)
      args.checkSymbolTable();
    validateMethodCall(ident, args);
  }

  public String typeCheck() {return "";}

  public String toString() {
    if (args == null)
      return(""+ident+"();");
    else
      return(""+ident+"("+args+");");
  }

}