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

  public void checkSymbolTable()
  {
    expression1.checkSymbolTable();
    expression2.checkSymbolTable();
    expression3.checkSymbolTable();

    String t1 = expression1.typeCheck();
    String t2 = expression2.typeCheck();
    String t3 = expression3.typeCheck();

    if(coercivelyEquals("BOOL", t1)&&(intFloatEquals(t2, t3)))
      System.out.println("Ternary operation performed with types ["+t1+", "+t2+", "+t3+"]. --> OK");
    else
      typeMismatch("Attempted to perform ternary operation with types ["+t1+", "+t2+", "+t3+"]. Expected [BOOL, "+t2+", "+t2+"]");

  }

  private boolean intFloatEquals(String t2, String t3)
  {
    if(t2.equals(t3))
      return true;
    else if(t2.equals("FLOAT")&&t3.equals("INT"))
      return true;
    else if(t3.equals("FLOAT")&&t2.equals("INT"))
      return true;
    else
      return false;
  }

  public String typeCheck()
  {
    return expression2.typeCheck();
  }


  public String toString() {
    return("("+expression1+" ? "+expression2+" : "+expression3+")");
  }

}