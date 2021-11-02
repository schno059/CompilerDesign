class ASTStmtAssign extends ASTStmt {
  String variable;
  ASTExpr arrayIndex;
  ASTExpr expression;
  STVarDeclEntry varEntry;

  public ASTStmtAssign(String v, ASTExpr ai, ASTExpr e) {
    variable = v;
    arrayIndex = ai;
    expression = e;
    varEntry = null;
  }

  public String toString(int indent) {
    return AST.indentString(indent) + variable + ((arrayIndex == null) ? "" : arrayIndex) + " = " + expression + ";\n";
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    varEntry = (STVarDeclEntry) SymbolTable.findName(variable);
    // STVarDeclEntry varEntry = (STVarDeclEntry) SymbolTable.findName(variable);
    if (varEntry == null) {
      SymbolTable.reportError("Variable " + variable + " not found");
      return;
    }
    Type t = expression.processNamesTypeCheck();
    if (arrayIndex == null) {
      if (t.typeMatches(varEntry.varType)) {
      }
      else {
        SymbolTable.reportError("Type of expression " + expression.toString() + " does not match Variable " + variable + " " + t.toString() + " and " + varEntry.varType);
      }
    }
    else {
      Type aT = arrayIndex.processNamesTypeCheck();
      if (isIntType(aT)) {
        if (varEntry.varType instanceof TypeArray) {
          if (t.typeMatches(((TypeArray) varEntry.varType).ofType)) {
          }
          else {
            Type aType = ((TypeArray) varEntry.varType).ofType;
            if (isBoolType(aType) && isIntType(t)) {
              expression = new ASTExprCast(sym.BOOL,expression);
            }
            else {
              if (isFloatType(aType) && isIntType(t)) {
                expression = new ASTExprCast(sym.FLOAT,expression);
              }
              else {
                SymbolTable.reportError("Type of expression " + expression.toString() + " does not match entries in Array " + variable + " " + t.toString() + " and " + ((TypeArray) varEntry.varType).ofType);
              }
            }
          }
        }
        else {
          SymbolTable.reportError("Attempt to array index into variable " + variable + " which is not an array");
        }
      }
      else {
        SymbolTable.reportError("Array reference must be of type integer, expr: " + arrayIndex.toString() + " is of type " + aT.toString());
      }
    }
  }

  public void run(){
    varEntry.exprValue = expression.exprValue();
  }

}


