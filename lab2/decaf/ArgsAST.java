
/**
 * AST node for arguments
 */ 
class ArgsAST extends StmtAST implements AST {
  ExprAST expression;
  ArgsAST args;

  public ArgsAST(ExprAST e) {
    expression = e;
  }

  public ArgsAST(ExprAST e, ArgsAST a) {
    expression = e;
    args = a;
  }

  public String toString() {
    if (args == null)
      return(""+expression);
    else
      return(""+expression+", "+args);
  }

}


