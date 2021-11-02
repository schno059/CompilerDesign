
/**
 * AST node for binary expressions
 */ 
class BinaryExprAST extends ExprAST implements AST {
  ExprAST leftarg, rightarg;
  String operator;

  public BinaryExprAST(ExprAST left, String op, ExprAST right) {
    leftarg = left;
    operator = op;
    rightarg = right;
  }

  public String toString() {
    return("("+leftarg+" "+operator+" "+rightarg+")"); 
  }

}


