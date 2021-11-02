/**
 * AST node for a question colon expression
 */ 
class QColExprAST extends ExprAST implements AST {
  ExprAST expression1;
  ExprAST expression2;
  ExprAST expression3;             

  public QColExprAST(ExprAST e1, ExprAST e2, ExprAST e3) {
  	expression1 = e1;
  	expression2 = e2;
  	expression3 = e3;
  }

  public String toString() {
    return("("+expression1+" ? "+expression2+" : "+expression3+")");
  }

}