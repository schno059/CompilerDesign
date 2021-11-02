
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

  public String toString() {
    if (args == null)
      return(""+ident+"();");
    else
      return(""+ident+"("+args+")");
  }

}