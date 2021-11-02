class ASTExprArrayRef extends ASTExpr {
  String varName;                
  ASTExpr argument;
  STVarDeclEntry arrayEntry;

  public ASTExprArrayRef(String v, ASTExpr a) {
    varName = v; 
    argument = a;
  }

  public String toString() {
    return varName + "[" + argument + "]";
  }

  public Type processNamesTypeCheck() {
    Type returnType = null;
    STEntry findSTE = SymbolTable.findName(varName);
    Type argType = argument.processNamesTypeCheck();
    if (findSTE == null) {
      SymbolTable.reportError("Array " + varName + " not declared");
      returnType = new TypeError();
    }
    if (!isIntType(argType)) {
      SymbolTable.reportError("Array reference " + argument.toString() + " not of type INT");
      if (returnType == null) returnType = new TypeError();
    }
    if (returnType == null) {
      arrayEntry = (STVarDeclEntry) findSTE;
      Type varType = arrayEntry.varType;
      if (varType instanceof TypeArray) {
        return ((TypeArray) varType).ofType;
      }
      else {
        SymbolTable.reportError("Variable " + varName + " not an array");
        if (returnType == null) returnType = new TypeError();
      }
    }
    return returnType;
  }

}


