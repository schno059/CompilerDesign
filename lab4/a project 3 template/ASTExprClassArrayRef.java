class ASTExprClassArrayRef extends ASTExpr {
  String className;                
  String fieldName;
  ASTExpr argument;
  STClassEntry classEntry;
  STVarDeclEntry fieldEntry;

  public ASTExprClassArrayRef(String c, String f, ASTExpr e) {
    className = c; 
    fieldName = f;
    argument = e;
    classEntry = null;
    fieldEntry = null;
  }

  public String toString() {
    return className + "." + fieldName + "[" + argument.toString() + "]";
  }

  public Type processNamesTypeCheck() {
    Type returnType = null;
    STEntry findSTE = SymbolTable.findName(className + SymbolTable.CLASS_EXTENSION);
    if (findSTE == null) {
      SymbolTable.reportError("Class " + className + " undeclared");
      returnType = new TypeError();
    }
    else {
      classEntry = (STClassEntry) findSTE;
      findSTE = classEntry.classScope.findName(fieldName);
      if (findSTE == null) {
        SymbolTable.reportError("Array " + fieldName + " not declared in class " + className);
        returnType = new TypeError();
      }
      fieldEntry = (STVarDeclEntry) findSTE;
    }
    Type argType = argument.processNamesTypeCheck();
    if (!isIntType(argType)) {
      SymbolTable.reportError("Array reference " + argument.toString() + " not of type INT");
      if (returnType == null) returnType = new TypeError();
    }
    if (returnType == null) {
      Type varType = fieldEntry.varType;
      if (varType instanceof TypeArray) {
        return ((TypeArray) varType).ofType;
      }
      else {
        SymbolTable.reportError("Field " + fieldName + " in class " + className + " not an array");
        if (returnType == null) returnType = new TypeError();
      }
    }
    return returnType;
  }

}


