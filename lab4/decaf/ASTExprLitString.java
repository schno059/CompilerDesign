class ASTExprLitString extends ASTExpr {
  String stringLit;
  String printableStringLit;

  private ASTExprLitString() {}

  public ASTExprLitString(String s) {
    stringLit = s;
    printableStringLit = "";
    for (int i = 0; i < s.length(); i++) {
      if (stringLit.charAt(i) == '\\') {
        printableStringLit += "\\";
      }
      else {
        printableStringLit += stringLit.substring(i,i+1);
      }
    }
  }

  public String toString() {
     return printableStringLit;
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.STRING);
  }

  public ASTExpr exprValue() {
    if(printableStringLit.charAt(0) == '\"')
      printableStringLit = printableStringLit.substring(1,printableStringLit.length()-1);
    return this;
  }
  
}

