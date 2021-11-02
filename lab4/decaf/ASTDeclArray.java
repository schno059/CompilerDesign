class ASTDeclArray extends ASTDecl {

  Integer typeNum;
  String typeName;
  String varName;
  Integer arraySize;

  public ASTDeclArray(Integer tnum, String vname, String intlit) {
    typeNum = tnum;
    typeName = null;
    varName = vname;
    arraySize = Integer.valueOf(intlit);
  }

  public ASTDeclArray(String tname, String vname, String intlit) {
    typeNum = null;
    typeName = tname;
    varName = vname;
    arraySize = Integer.valueOf(intlit);
  }

  public String toString(int indent) {
    return AST.indentString(indent) + ((typeNum == null) ? typeName : sym.terminalNames[typeNum].toLowerCase()) + " " + varName + "[" + arraySize.toString() +  "];\n";
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    if (typeName == null) {
      STEntry newSTE = new STVarDeclEntry(varName,false,new TypeArray(arraySize,((Type) new TypeBase(typeNum))),null);
      if (!SymbolTable.insertName(varName,newSTE)) {
        SymbolTable.reportError("Variable " + varName + " multiply declared");
      }
    }
    else {
      STEntry findSTE = SymbolTable.findName(typeName + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Unable to find class " + typeName + " for variable " + varName + "(looking for " + typeName + SymbolTable.CLASS_EXTENSION + ")");
      }
      else {
        STEntry newSTE =  new STVarDeclEntry(varName,false,new TypeArray(arraySize,((Type) new TypeClass(typeName,findSTE))),null);
        if (!SymbolTable.insertName(varName,newSTE)) {
          SymbolTable.reportError("Variable " + varName + " multiply declared");
        }
      }
    }
  }

}


