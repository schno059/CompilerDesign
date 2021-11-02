/**
 * AST node for a tilde expression
 */ 
class TildeExprAST extends ExprAST implements AST {
  ExprAST expression;                

  public TildeExprAST(ExprAST e) {
    expression = e; 
  }

  public void checkSymbolTable()
  {
    expression.checkSymbolTable();
    String type = expression.typeCheck();

    if(type.equalsIgnoreCase("INT")||type.equalsIgnoreCase("BOOL"))
      System.out.println("Tilde operation with "+expression+" which is of type "+type+". --> OK");
    else
      typeMismatch("Attempted tilde operation with "+expression+" which is of type "+type+". Acceptable types are [BOOL, INT]");
  }

  public String typeCheck()
  {
    return "BOOL";
  }

  public String toString() {
    return("~"+expression);
  }

}