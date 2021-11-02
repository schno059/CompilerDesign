/**
 * AST node for binary expressions
 */ 
class ASTExprBinary extends ASTExpr {
  ASTExpr leftarg, rightarg;
  Integer operator;

  public ASTExprBinary(ASTExpr left, Integer op, ASTExpr right) {
    leftarg = left;
    operator = op;
    rightarg = right;
  }

  public Type processNamesTypeCheck() {
    Type leftType = leftarg.processNamesTypeCheck();
    Type rightType = rightarg.processNamesTypeCheck();
    boolean leftIsError = (leftType instanceof TypeError);
    boolean rightIsError = (rightType instanceof TypeError);
    Type resultType = null;

    if (leftIsError && rightIsError) {
      return leftType;
    }
    if (leftIsError || rightIsError) {
      Type workingType = (leftIsError ? rightType : leftType);
      switch (operator) {
        case sym.PLUS:
          if (isStringType(workingType)) return workingType;
        case sym.MINUS: case sym.TIMES: case sym.DIV:
          if (isIntType(workingType) || isFloatType(workingType)) return workingType;
          break;
        case sym.LESSTHAN: case sym.GREATERTHAN: case sym.LESSEQUAL: case sym.GREATEREQUAL: case sym.EQUALEQUAL: case sym.NOTEQUAL:
          if (workingType instanceof TypeBase) return new TypeBase(sym.BOOL);
          break;
        case sym.LOR: case sym.LAND:
          if (isIntType(workingType) || isBoolType(workingType)) return new TypeBase(sym.BOOL);
          break;
      }
      if (leftIsError)
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + rightarg.toString() + " of type: " + rightType.toString());
      else
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + leftarg.toString() + " of type: " + leftType.toString());
      return new TypeError();
    }
    switch (operator) {
      case sym.PLUS:
        if (isStringType(leftType) && isStringType(rightType)) return leftType;
      case sym.MINUS: case sym.TIMES: case sym.DIV:
        if (isIntType(leftType) && isIntType(rightType)) return leftType;
        if (isFloatType(leftType) && isFloatType(rightType)) return leftType;
        if (isIntType(leftType) && isFloatType(rightType)) {
          leftarg = new ASTExprCast(sym.FLOAT,leftarg);
          return rightType;
        }
        if (isFloatType(leftType) && isIntType(rightType)) {
          rightarg = new ASTExprCast(sym.FLOAT,rightarg);
          return leftType;
        }
        if (isIntType(leftType) || isFloatType(leftType)) {
          SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + rightarg.toString() + " of type: " + rightType.toString());
          return leftType;
        }
        if (isIntType(rightType) || isFloatType(rightType)) {
          SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + leftarg.toString() + " of type: " + leftType.toString());
          return rightType;
        }
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + rightarg.toString() + " of type: " + rightType.toString());
        SymbolTable.reportError("operator " + getOperatorName(operator) + " does not apply to expression: " + leftarg.toString() + " of type: " + leftType.toString());
        return new TypeError();
      case sym.LESSTHAN: case sym.GREATERTHAN: case sym.LESSEQUAL: case sym.GREATEREQUAL: case sym.EQUALEQUAL: case sym.NOTEQUAL:
        if ((leftType instanceof TypeBase) && (rightType instanceof TypeBase)) {
          if (((TypeBase) leftType).typeNum == ((TypeBase) rightType).typeNum) return new TypeBase(sym.BOOL);
          if ((((TypeBase) leftType).typeNum == sym.INT) && (((TypeBase) rightType).typeNum == sym.FLOAT)) {
            leftarg = new ASTExprCast(sym.FLOAT,leftarg);
            return new TypeBase(sym.BOOL);
          }
          if ((((TypeBase) leftType).typeNum == sym.FLOAT) && (((TypeBase) rightType).typeNum == sym.INT)) {
            rightarg = new ASTExprCast(sym.FLOAT,rightarg);
            return new TypeBase(sym.BOOL);
          }
          SymbolTable.reportError("operator " + getOperatorName(operator) + " cannot compare arguments of type " + leftType.toString() + " and " + rightType.toString() + " for expressions " + leftarg.toString() + " and " + rightarg.toString());
          return new TypeBase(sym.BOOL);
        }
        SymbolTable.reportError("operator " + getOperatorName(operator) + " cannot compare arguments of type " + leftType.toString() + " and " + rightType.toString() + " for expressions " + leftarg.toString() + " and " + rightarg.toString());
        return new TypeBase(sym.BOOL);
      case sym.LOR: case sym.LAND:
        if (isBoolType(leftType) && isBoolType(rightType)) return leftType;
        if (isIntType(leftType) && isIntType(rightType)) {
          leftarg = new ASTExprCast(sym.BOOL,leftarg);
          rightarg = new ASTExprCast(sym.BOOL,rightarg);
          return new TypeBase(sym.BOOL);
        }
        if (isIntType(leftType) && isBoolType(rightType)) {
          leftarg = new ASTExprCast(sym.BOOL,leftarg);
          return new TypeBase(sym.BOOL);
        }
        if (isBoolType(leftType) && isIntType(rightType)) {
          rightarg = new ASTExprCast(sym.BOOL,rightarg);
          return new TypeBase(sym.BOOL);
        }
        SymbolTable.reportError("operator " + getOperatorName(operator) + " cannot compare arguments of type " + leftType.toString() + " and " + rightType.toString() + " for expressions " + leftarg.toString() + " and " + rightarg.toString());
        return new TypeBase(sym.BOOL);
    }
    return new TypeError();
  }

  public String toString() {
    String result = "(" + leftarg + " ";
    result += getOperatorName(operator);
    result += " " + rightarg + ")";
    return result;
  }

  public Type typeCheck() {
    Type leftType = leftarg.typeCheck();
    Type rightType = rightarg.typeCheck();
    boolean leftIsError = (leftType instanceof TypeError);
    boolean rightIsError = (rightType instanceof TypeError);
    Type resultType = null;

    if (leftIsError && rightIsError) {
      return leftType;
    }
    if (leftIsError || rightIsError) {
      Type workingType = (leftIsError ? rightType : leftType);
      switch (operator) {
        case sym.PLUS:
          if (isStringType(workingType)) return workingType;
        case sym.MINUS: case sym.TIMES: case sym.DIV:
          if (isIntType(workingType) || isFloatType(workingType)) return workingType;
          break;
        case sym.LESSTHAN: case sym.GREATERTHAN: case sym.LESSEQUAL: case sym.GREATEREQUAL: case sym.EQUALEQUAL: case sym.NOTEQUAL:
          if (workingType instanceof TypeBase) return new TypeBase(sym.BOOL);
          break;
        case sym.LOR: case sym.LAND:
          if (isIntType(workingType) || isBoolType(workingType)) return new TypeBase(sym.BOOL);
          break;
      }
      return new TypeError();
    }
    switch (operator) {
      case sym.PLUS:
        if (isStringType(leftType) && isStringType(rightType)) return leftType;
      case sym.MINUS: case sym.TIMES: case sym.DIV:
        if (isIntType(leftType) && isIntType(rightType)) return leftType;
        if (isFloatType(leftType) && isFloatType(rightType)) return leftType;
        if (isIntType(leftType) && isFloatType(rightType)) {
          leftarg = new ASTExprCast(sym.FLOAT,leftarg);
          return rightType;
        }
        if (isFloatType(leftType) && isIntType(rightType)) {
          rightarg = new ASTExprCast(sym.FLOAT,rightarg);
          return leftType;
        }
        if (isIntType(leftType) || isFloatType(leftType)) {
          return leftType;
        }
        if (isIntType(rightType) || isFloatType(rightType)) {
          return rightType;
        }
        return new TypeError();
      case sym.LESSTHAN: case sym.GREATERTHAN: case sym.LESSEQUAL: case sym.GREATEREQUAL: case sym.EQUALEQUAL: case sym.NOTEQUAL:
        if ((leftType instanceof TypeBase) && (rightType instanceof TypeBase)) {
          if (((TypeBase) leftType).typeNum == ((TypeBase) rightType).typeNum) return new TypeBase(sym.BOOL);
          if ((((TypeBase) leftType).typeNum == sym.INT) && (((TypeBase) rightType).typeNum == sym.FLOAT)) {
            leftarg = new ASTExprCast(sym.FLOAT,leftarg);
            return new TypeBase(sym.BOOL);
          }
          if ((((TypeBase) leftType).typeNum == sym.FLOAT) && (((TypeBase) rightType).typeNum == sym.INT)) {
            rightarg = new ASTExprCast(sym.FLOAT,rightarg);
            return new TypeBase(sym.BOOL);
          }
          return new TypeBase(sym.BOOL);
        }
        return new TypeBase(sym.BOOL);
      case sym.LOR: case sym.LAND:
        if (isBoolType(leftType) && isBoolType(rightType)) return leftType;
        if (isIntType(leftType) && isIntType(rightType)) {
          leftarg = new ASTExprCast(sym.BOOL,leftarg);
          rightarg = new ASTExprCast(sym.BOOL,rightarg);
          return new TypeBase(sym.BOOL);
        }
        if (isIntType(leftType) && isBoolType(rightType)) {
          leftarg = new ASTExprCast(sym.BOOL,leftarg);
          return new TypeBase(sym.BOOL);
        }
        if (isBoolType(leftType) && isIntType(rightType)) {
          rightarg = new ASTExprCast(sym.BOOL,rightarg);
          return new TypeBase(sym.BOOL);
        }
        return new TypeBase(sym.BOOL);
    }
    return new TypeError();
  }

  public ASTExpr exprValue() {
    ASTExpr returnExpr = this;
    String returnType = typeCheck().toString();

    if(returnType.equals("int"))
    {
      int l = Integer.valueOf(leftarg.exprValue().toString()).intValue();
      int r = Integer.valueOf(rightarg.exprValue().toString()).intValue();
      switch (operator) {
        case sym.PLUS:
          returnExpr = new ASTExprLitInt(l+r);
          break;
        case sym.MINUS:
          returnExpr = new ASTExprLitInt(l-r);
          break;
        case sym.TIMES:
          returnExpr = new ASTExprLitInt(l*r);
          break;
        case sym.DIV:
          returnExpr = new ASTExprLitInt(l/r);
          break;
      }
    }
    else if(returnType.equals("float"))
    {
      double l = Double.parseDouble(leftarg.exprValue().toString());
      double r = Double.parseDouble(rightarg.exprValue().toString());
      switch (operator) {
        case sym.PLUS:
          returnExpr = new ASTExprLitFloat(l+r);
          break;
        case sym.MINUS:
          returnExpr = new ASTExprLitFloat(l-r);
          break;
        case sym.TIMES:
          returnExpr = new ASTExprLitFloat(l*r);
          break;
        case sym.DIV:
          returnExpr = new ASTExprLitFloat(l/r);
          break;
      }
    }
    else if(returnType.equals("bool"))
    {
      String l = leftarg.exprValue().toString();
      String r = rightarg.exprValue().toString();
      boolean ltrue = l.equals("true");
      boolean rtrue = r.equals("true");

      try {
        switch (operator) {
          case sym.LOR:
            returnExpr = new ASTExprLitBool(ltrue||rtrue);
            break;
          case sym.LAND:
            returnExpr = new ASTExprLitBool(ltrue&&rtrue);
            break;
          case sym.EQUALEQUAL:
            returnExpr = new ASTExprLitBool(l.equals(r));
            break;
          case sym.NOTEQUAL:
            returnExpr = new ASTExprLitBool(!l.equals(r));
            break;
          case sym.LESSEQUAL:
            returnExpr = new ASTExprLitBool(Double.parseDouble(l)<=Double.parseDouble(r));
            break;
          case sym.GREATEREQUAL:
            returnExpr = new ASTExprLitBool(Double.parseDouble(l)>=Double.parseDouble(r));
            break;
          case sym.LESSTHAN:
            returnExpr = new ASTExprLitBool(Double.parseDouble(l)<Double.parseDouble(r));
            break;
          case sym.GREATERTHAN:
            returnExpr = new ASTExprLitBool(Double.parseDouble(l)>Double.parseDouble(r));
            break;
        }
      }
      catch(Exception e) {
        returnExpr = new ASTExprLitBool(false);
      }
    }

    return returnExpr;
  }

}


