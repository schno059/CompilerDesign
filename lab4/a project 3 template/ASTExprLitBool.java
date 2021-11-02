/**
 * AST node for a BoolLit
 */ 
class ASTExprLitBool extends ASTExpr {
  Boolean boolLit;
 
  private ASTExprLitBool() {}

  public ASTExprLitBool(String s) {
    if (s.equals("true")) {
      boolLit = new Boolean(true);
    }
    else {
      boolLit = new Boolean(false);
    }
  }

  public ASTExprLitBool(boolean b) {
    boolLit = b;
  }

  public String toString() {
     return boolLit.toString();
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.BOOL);
  }
}

