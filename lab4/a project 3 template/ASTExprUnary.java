class ASTExprUnary extends ASTExpr {
  ASTExpr argument;
  Integer operator;

  public ASTExprUnary(Integer op, ASTExpr arg) {
    operator = op;
    argument = arg;
  }

  public String toString() {
    String result = "(";
    switch (operator) {
      case sym.UMINUS:
        result += "-"; break;
      case sym.UPLUS:
        result += "+"; break;
      case sym.LNOT:
        result += "~"; break;
    }
    result += " " + argument + ")";
    return result;
  }

  public Type processNamesTypeCheck() {
    Type argType = argument.processNamesTypeCheck();
    
    if (argType instanceof TypeError) return argType;
    switch (operator) {
      case sym.UMINUS: case sym.UPLUS:
        if (isIntType(argType) || isFloatType(argType))
          return argType;
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + argument.toString() + " of type: " + argType.toString());
        return new TypeError();
      case sym.LNOT:
        if (isBoolType(argType)) return argType;
        if (isIntType(argType)) {
          argument = new ASTExprCast(sym.BOOL,argument);
          return new TypeBase(sym.BOOL);
        }
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + argument.toString() + " of type: " + argType.toString());
        return new TypeError();
    }
    SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + argument.toString() + " of type: " + argType.toString());
    return new TypeError();
  }
}


