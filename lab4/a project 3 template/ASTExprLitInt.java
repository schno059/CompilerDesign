class ASTExprLitInt extends ASTExpr {
  public Integer intLit;

  private ASTExprLitInt() {}

  public ASTExprLitInt(String s) {
    intLit = Integer.valueOf(s);
  }

  public ASTExprLitInt(int i) {
    intLit = i;
  }

  public String toString() {
     return(""+intLit.toString());
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.INT);
  }

}

