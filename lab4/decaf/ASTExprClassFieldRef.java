class ASTExprClassFieldRef extends ASTExpr {
  String className;                
  String fieldName;
  STClassEntry classEntry;
  STVarDeclEntry fieldEntry;

  public ASTExprClassFieldRef(String c, String f) {
    className = c; 
    fieldName = f;
    classEntry = null;
  }

  public String toString() {
    return className + "." + fieldName;
  }

  public Type processNamesTypeCheck() {
    STEntry findSTE = SymbolTable.findName(className + SymbolTable.CLASS_EXTENSION);
    if (findSTE == null) {
      SymbolTable.reportError("Class " + className + " undeclared");
      return new TypeError();
    }
    classEntry = (STClassEntry) findSTE;

    findSTE = classEntry.classScope.findName(fieldName);
    if (findSTE == null) {
      SymbolTable.reportError("Field " + fieldName + " in class " + className + " undeclared");
      return new TypeError();
    }
    
    fieldEntry = (STVarDeclEntry) findSTE;
    return fieldEntry.varType;
  }

}


