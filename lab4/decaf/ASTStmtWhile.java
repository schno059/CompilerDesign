class ASTStmtWhile extends ASTStmt {
  ASTExpr testExpression;
  ASTStmt doStmt;

  public ASTStmtWhile(ASTExpr e, ASTStmt s) {
    testExpression = e;
    doStmt = s;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent);
    result += "while " + testExpression.toString() + "\n";
    result += doStmt.toString(indent+1);
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    Type testType = testExpression.processNamesTypeCheck();

    if (isIntType(testType)) {
      testExpression = new ASTExprCast(sym.BOOL,testExpression);
    }
    else {
      if (!isBoolType(testType))
        SymbolTable.reportError("Type of expression for WHILE should be bool :" + testExpression.toString());
    }

    doStmt.processNames();
  }

  public void run() {
    while(testExpression.exprValue().toString().equals("true")) { doStmt.run(); }
  }


}


