/**
 * AST node for a plus expression
 */ 
class PlusExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public PlusExprAST(ExprAST e) {
    expression = e; 
  }

  public String toString() {
    return("+"+expression);
  }

}