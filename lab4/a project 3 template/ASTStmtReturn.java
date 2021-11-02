import java.util.*;

class ASTStmtReturn extends ASTStmt {
  ASTExpr returnExpr;
  STMethodDeclEntry methodEntry;

  public ASTStmtReturn(ASTExpr re) {
    returnExpr = re;
  }

  public String toString(int indent) {
    return AST.indentString(indent) + "return" + ((returnExpr == null) ? "" : (" " + returnExpr.toString())) + ";\n";
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    methodEntry = SymbolTable.getCurrentMethod();
    Type t;
    if (returnExpr == null) {
      t = new TypeBase(sym.VOID);
    }
    else {
      t = returnExpr.processNamesTypeCheck();
    }

    if (!(t instanceof TypeError)) {
      if (!(t.typeMatches(methodEntry.methodType))) {
        SymbolTable.reportError("Return value " + ((returnExpr == null) ? "void" : returnExpr.toString()) + " does not match return type of function " + methodEntry.methodType.toString());
        return;
      }
    }
  }

}


