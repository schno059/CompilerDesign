class ASTExprVarRef extends ASTExpr {
  String varName;                
  STVarDeclEntry varEntry;
  Type varType;

  public ASTExprVarRef(String s) {
    varName = s; 
    varEntry = null;
    varType = null;
  }

  public String toString() {
    return varName; 
  }

  public Type processNamesTypeCheck() {
    STEntry findSTE = SymbolTable.findName(varName);
    if (findSTE == null) {
      SymbolTable.reportError("Variable " + varName + " undeclared");
      varType = new TypeError();
    }
    else {
      varEntry = (STVarDeclEntry) findSTE;
      varType = varEntry.varType;
    }
    return varType;
  }

  public Type typeCheck() {
    return varType;
  }

  public ASTExpr exprValue() {
    return varEntry.exprValue.exprValue();
  }
}


