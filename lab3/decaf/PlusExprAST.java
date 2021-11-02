/**
 * AST node for a plus expression
 */ 
class PlusExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public PlusExprAST(ExprAST e) {
    expression = e; 
  }

  public void checkSymbolTable()
  {
  	expression.checkSymbolTable();
    String type = expression.typeCheck();

    if(type.equalsIgnoreCase("INT")||type.equalsIgnoreCase("FLOAT"))
      System.out.println("Unary plus operation with "+expression+" which is of type "+type+". --> OK");
    else
      typeMismatch("Attempted unary plus operation with "+expression+" which is of type "+type+". Acceptable types are [INT, FLOAT]");
  }

  public String typeCheck()
  {
    return expression.typeCheck();
  }

  public String toString() {
    return("+"+expression);
  }

}