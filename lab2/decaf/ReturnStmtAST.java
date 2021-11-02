
/**
 * AST node for return statements
 */ 
class ReturnStmtAST extends StmtAST implements AST {
  ExprAST expression;

  public ReturnStmtAST() {}

  public ReturnStmtAST(ExprAST e) {
    expression = e;
  }

  public String toString() {
    if (expression == null)
      return("return;");
    else
      return("return "+expression+";");
  }

}