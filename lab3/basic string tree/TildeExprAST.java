/**
 * AST node for a tilde expression
 */ 
class TildeExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public TildeExprAST(ExprAST e) {
    expression = e; 
  }

  public String toString() {
    return("~"+expression);
  }

}