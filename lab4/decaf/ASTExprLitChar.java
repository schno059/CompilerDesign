/**
 * AST node for a CharLit
 */ 
class ASTExprLitChar extends ASTExpr {
  String charLit;
  String cushionedCharLit;

  private ASTExprLitChar() {}

  public ASTExprLitChar(String s) {
    if (s == null) {
      charLit = "";
    }
    else {
      if(s.length() == 1) {
        charLit = s;
      } else if (s.length() == 3) {
        charLit = s.substring(1,2);
      } else {
        if (s.length() == 4) {
          charLit = s.substring(1,3);
        }
        else {
          System.err.println("Unexpected character literal " + s);
          charLit = "";
        }
      }
    }
    if (charLit.length() == 2)
      cushionedCharLit = "'\\" + charLit.substring(1,2) + "'";
    else
      cushionedCharLit = "'" + charLit + "'";
  }

  public ASTExprLitChar(char c) {
    charLit = Character.toString(c);
    cushionedCharLit = "'" + charLit + "'";
  }

  public String toString() {
    return cushionedCharLit;
  }

  public Type processNamesTypeCheck() {
    return new TypeBase(sym.CHAR);
  }

  public ASTExpr exprValue() {
    if(cushionedCharLit.charAt(0) == '\'')
      cushionedCharLit = cushionedCharLit.substring(1,cushionedCharLit.length()-1);
    return this;
  }
  
}

