class ASTExprCast extends ASTExpr {
  ASTExpr argument;
  Integer typeNum;

  public ASTExprCast(Integer tn, ASTExpr arg) {
    typeNum = tn;
    argument = arg;
  }

  public String toString() {
    return "((" + sym.terminalNames[typeNum].toLowerCase() + ") " + argument + ")";
  }

  public Type processNamesTypeCheck() {
    Type argType = argument.processNamesTypeCheck();
    if (argType instanceof TypeBase) {
      TypeBase bargType = (TypeBase) argType;
      if (bargType.typeNum == typeNum) return bargType;
      if ((typeNum == sym.BOOL) && (bargType.typeNum == sym.INT)) return new TypeBase(sym.BOOL);
      if ((typeNum == sym.FLOAT) && (bargType.typeNum == sym.INT)) return new TypeBase(sym.FLOAT);
    }
    return new TypeError();
  }

  public ASTExpr exprValue()
  {
    ASTExpr returnExpr = argument.exprValue();
    Type argType = argument.processNamesTypeCheck();
    if (argType instanceof TypeBase) {
      TypeBase bargType = (TypeBase) argType;
      if ((typeNum == sym.BOOL) && (bargType.typeNum == sym.INT)) returnExpr = new ASTExprLitBool(!argument.exprValue().toString().equals("0"));
      if ((typeNum == sym.FLOAT) && (bargType.typeNum == sym.INT)) returnExpr = new ASTExprLitFloat(argument.exprValue().toString());
    }
    return returnExpr;
  }
  
}


