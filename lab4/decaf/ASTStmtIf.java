class ASTStmtIf extends ASTStmt {
  ASTExpr testExpression;
  ASTStmt thenStmt;
  ASTStmt elseStmt;

  public ASTStmtIf(ASTExpr e, ASTStmt ts, ASTStmt es) {
    testExpression = e;
    thenStmt = ts;
    elseStmt = es;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent);
    result += "if " + testExpression.toString() + "\n";
    result += thenStmt.toString(indent+1);
    if (elseStmt != null) {
      result += AST.indentString(indent);
      result += "else\n";
      result += elseStmt.toString(indent+1);
    }
    result += AST.indentString(indent);
    result += "fi\n";
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
        SymbolTable.reportError("Type of expression for IF should be bool :" + testExpression.toString());
    }

    thenStmt.processNames();
    if (elseStmt != null) elseStmt.processNames();
  }

  public void run()
  {
    // System.out.println("IF STATEMENT RUNNING");
    if(testExpression.exprValue().toString().equals("true"))
    	thenStmt.run();
    else if(elseStmt!=null)
    	elseStmt.run();
  }
}


