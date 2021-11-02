class ASTDeclVar extends ASTDecl {

  Boolean finalVar;
  Integer typeNum;
  String typeName;
  String varName;
  ASTExpr eValue;

  public ASTDeclVar(Boolean fvar, Integer tnum, String vname, ASTExpr e) {
    finalVar = fvar;
    typeNum = tnum;
    typeName = null;
    varName = vname;
    eValue = e;
  }

  public ASTDeclVar(Boolean fvar, String tname, String vname, ASTExpr e) {
    finalVar = fvar;
    typeName = tname;
    typeNum = null;
    varName = vname;
    eValue = e;
  }

  public String toString(int indent) {
    return AST.indentString(indent) + (finalVar ? "final " : "") + ((typeNum == null) ? typeName : sym.terminalNames[typeNum].toLowerCase()) + " " + varName + (eValue == null ? "" : (" = " + eValue.toString())) + ";\n";
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    if (typeName == null) {
      // parser does not allow case where final does not have initial expression
      if (eValue == null) {
        switch (typeNum) {
          case sym.INT: eValue = (ASTExpr) new ASTExprLitInt(0); break;
          case sym.CHAR: eValue = (ASTExpr) new ASTExprLitChar('\0'); break;
          case sym.FLOAT: eValue = (ASTExpr) new ASTExprLitFloat(0.0); break;
          case sym.STRING: eValue = (ASTExpr) new ASTExprLitString(""); break;
          case sym.BOOL: eValue = (ASTExpr) new ASTExprLitBool(false); break;
        }
      }
      Type eType = eValue.processNamesTypeCheck();
      if ((typeNum == sym.FLOAT) && (eType instanceof TypeBase) && (((TypeBase) eType).typeNum == sym.INT)) {
        eValue = new ASTExprCast(sym.FLOAT,eValue);
        eType = new TypeBase(sym.FLOAT);
      }
      if ((typeNum == sym.BOOL) && (eType instanceof TypeBase) && (((TypeBase) eType).typeNum == sym.INT)) {
        eValue = new ASTExprCast(sym.BOOL,eValue);
        eType = new TypeBase(sym.BOOL);
      }
      STVarDeclEntry newSTE = new STVarDeclEntry(varName,finalVar,new TypeBase(typeNum),eValue);
      if (eType.typeMatches(newSTE.varType)) {
        if (!SymbolTable.insertName(varName,newSTE)) {
          SymbolTable.reportError("Variable " + varName + " multiply declared");
        }
      }
      else {
        SymbolTable.reportError("Type of variable " + varName + " does not match expression " + eValue.toString() + " types are " + newSTE.varType + " and " + eType.toString());
      }
    }
    else {
      STEntry findSTE = SymbolTable.findName(typeName + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Unable to find class " + typeName + " for variable " + varName + "(looking for " + typeName + SymbolTable.CLASS_EXTENSION + ")");
      }
      else {
        STEntry newSTE =  new STVarDeclEntry(varName,false,new TypeClass(typeName,findSTE),null);
        if (!SymbolTable.insertName(varName,newSTE)) {
          SymbolTable.reportError("Variable " + varName + " multiply declared");
        }
      }
    }
  }


}
