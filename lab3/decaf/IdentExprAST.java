
/**
 * AST node for identifier expressions
 */ 
class IdentExprAST extends ExprAST implements AST {
  IdentAST ident;
  ArgsAST args;

  public IdentExprAST(IdentAST i) {
    ident = i;
  }

  public IdentExprAST(IdentAST i, ArgsAST a) {
    ident = i;
    args = a;
  }

  public void checkSymbolTable()
  {
    if(args!=null)
      args.checkSymbolTable();
  }

  public String typeCheck()
  {
    return validateMethodCall(ident, args);
    // return "INT";
  }

  public String toString() {
    if (args == null)
      return(""+ident+"();");
    else
      return(""+ident+"("+args+")");
  }

}