import java.util.*;

class ASTStmtRead extends ASTStmt {
  ArrayList<ASTExpr> expressions;

  public ASTStmtRead(ArrayList<ASTExpr> exprs) {
    expressions = exprs;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent) + "read(";
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
    for (ASTExpr expr : expressions) {
      if ((expr instanceof ASTExprVarRef) || (expr instanceof ASTExprArrayRef) ||
          (expr instanceof ASTExprClassArrayRef) || (expr instanceof ASTExprClassFieldRef)) {
        Type t = expr.processNamesTypeCheck();
        if (!(t instanceof TypeBase)) {
          SymbolTable.reportError("Read can not be applied to variables (" + expr.toString() + ") of base types, not " + t.toString());
          return;
        }
      }
      else {
        SymbolTable.reportError("Read can only be applied to variables, not " + expr.toString());
        return;
      }
      
    }
  }

}


