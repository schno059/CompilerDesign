
/**
 * AST node for field prime
 */ 
class FieldPrimeAST extends FieldAST implements AST {
  OptExprAST optexpression;
  OptIntAST number;

  public FieldPrimeAST(OptExprAST e) {
    optexpression = e;
  }

  public FieldPrimeAST(OptIntAST n) {
    number = n;
  }

  public String getSymbolExtension()
  {
    if(number==null)
      return("");
    else
      return("[]");
  }

  public void checkSymbolTable()
  {
    if(optexpression!=null)
      optexpression.checkSymbolTable();
    else if(number!=null)
      number.checkSymbolTable();
  }

  public String typeCheck()
  {
    if(optexpression!=null)
      return optexpression.typeCheck();
    else if(number!=null)
      return number.typeCheck();
    return "";
  }

  public ExprAST getExpression()
  {
    if(optexpression!=null)
      return optexpression.getExpression();
    return null;
  }

  public String toString() {
    if(number==null)
      return(""+optexpression+";");
    else
      return("["+number+"];");
  }

}


