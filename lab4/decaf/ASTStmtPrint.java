import java.util.*;

class ASTStmtPrint extends ASTStmt {
  ArrayList<ASTExpr> expressions;
  String postString;

  public ASTStmtPrint(ArrayList<ASTExpr> exprs, String ps) {
    expressions = exprs;
    postString = ps;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent) + ((postString == null) ? "print" : "printline") + "(";
    if ((expressions != null) && (expressions.size() > 0)) {
      result += expressions.get(0).toString();
      if (expressions.size() > 1) {
        for (int i = 1; i < expressions.size(); i++) {
          result = result + "," + expressions.get(i);
        }
      }
    }
    result = result + ");\n";
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    if (expressions != null) {
      Type eType;
      for (ASTExpr expr : expressions) {
        eType = expr.processNamesTypeCheck();
        if (!(eType instanceof TypeBase)) {
          SymbolTable.reportError("Cannot print items of type " + eType.toString() + " for " + expr.toString());
        }
      }
    }
  }

  public void run() {
    for (ASTExpr expression : expressions) {
      System.out.println(expression.exprValue());
    }
  }
}


