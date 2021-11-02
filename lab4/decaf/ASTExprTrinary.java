class ASTExprTrinary extends ASTExpr {
  ASTExpr expr1, expr2, expr3;

  public ASTExprTrinary(ASTExpr e1, ASTExpr e2, ASTExpr e3) {
    expr1 = e1;
    expr2 = e2;
    expr3 = e3;
  }

  public String toString() {
    return "(" + expr1 + " ? " + expr2 + " : " + expr3 + ")";
  }

  public Type processNamesTypeCheck() {
    Type e1Type = expr1.processNamesTypeCheck();
    Type e2Type = expr2.processNamesTypeCheck();
    Type e3Type = expr3.processNamesTypeCheck();
    Type returnType = null;
    if (isBoolType(e1Type)) {
    }
    else {
      if (isIntType(e1Type)) {
        expr1 = new ASTExprCast(sym.BOOL,expr1);
      }
      else {
        SymbolTable.reportError("operator ? does not apply to expression: " + expr1.toString() + " of type: " + e1Type.toString());
        returnType = new TypeError();
      }
    }
    if (e2Type.typeMatches(e3Type)) {
      if (returnType == null) returnType = e2Type;
    }
    else { 
      SymbolTable.reportError("types of : for ? do not match : " + e2Type.toString() + " and " + e3Type.toString() + " for " + expr2.toString() + " and " + expr3.toString());
      returnType = new TypeError();
    }
    return returnType;
  }
  
  public ASTExpr exprValue(){
    if(expr1.exprValue().toString().equals("true"))
      return expr2.exprValue();
    else
      return expr3.exprValue();
  }
}


