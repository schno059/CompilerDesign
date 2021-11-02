/**
 * AST node for a CharLit
 */ 
class ASTExprLitChar extends ASTExpr {
  String charLit;

  private ASTExprLitChar() {}

  public ASTExprLitChar(String s) {
    if (s == null) {
      charLit = "";
    }
    else {
      if (s.length() == 3) {
        charLit = s.substring(1,2);
      }
      else {
        if (s.length() == 4) {
          charLit = s.substring(1,3);
        }
        else {
          System.err.println("Unexpected character literal " + s);
          charLit = "";
        }
      }
    }
  }

  public ASTExprLitChar(char c) {
    charLit = Character.toString(c);
  }

  public String toString() {
     if (charLit.length() == 2)
       return "'\\" + charLit.substring(1,2) + "'";
     else
       return "'" + charLit + "'";
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.CHAR);
  }
}

