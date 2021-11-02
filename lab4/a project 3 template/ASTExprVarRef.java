class ASTExprVarRef extends ASTExpr {
  String varName;                
  STVarDeclEntry varEntry;

  public ASTExprVarRef(String s) {
    varName = s; 
    varEntry = null;
  }

  public String toString() {
    return varName; 
  }

  public Type processNamesTypeCheck() {
    STEntry findSTE = SymbolTable.findName(varName);
    if (findSTE == null) {
      SymbolTable.reportError("Variable " + varName + " undeclared");
      return new TypeError();
    }
    else {
      varEntry = (STVarDeclEntry) findSTE;
      return varEntry.varType;
    }
  }
}


