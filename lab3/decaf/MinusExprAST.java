/**
 * AST node for a minus expression
 */ 
class MinusExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public MinusExprAST(ExprAST e) {
    expression = e; 
  }

  public void checkSymbolTable()
  {
    expression.checkSymbolTable();
    String type = expression.typeCheck();

    if(type.equalsIgnoreCase("INT")||type.equalsIgnoreCase("FLOAT"))
      System.out.println("Unary minus operation with "+expression+" which is of type "+type+". --> OK");
    else
      typeMismatch("Attempted unary minus operation with "+expression+" which is of type "+type+". Acceptable types are [INT, FLOAT]");
  }

  public String typeCheck()
  {
    return expression.typeCheck();
  }

  public String toString() {
    return("-"+expression);
  }

}