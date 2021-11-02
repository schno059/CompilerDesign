/**
 * AST node for a minus expression
 */ 
class MinusExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public MinusExprAST(ExprAST e) {
    expression = e; 
  }

  public String toString() {
    return("-"+expression);
  }

}