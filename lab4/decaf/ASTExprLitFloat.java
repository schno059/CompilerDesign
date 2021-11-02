class ASTExprLitFloat extends ASTExpr {
  public Double floatLit;

  private ASTExprLitFloat() {}

  public ASTExprLitFloat(String s) {
    try { floatLit = Double.parseDouble(s); }
    catch (NumberFormatException e) { floatLit = Double.NaN; };
  }

  public ASTExprLitFloat(double d) {
    floatLit = d;
  }

  public String toString() {
    return(""+String.format("%.2f",floatLit)); 
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.FLOAT);
  }

}

