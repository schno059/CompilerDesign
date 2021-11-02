class ASTClass extends AST {
  String className;
  ASTListOfDecls declList;

  private ASTClass() {}

  public ASTClass(String cname, ASTListOfDecls decls) {
    className = cname;
    declList = decls;
  }

  public String toString() {
    String result = "";
    result += "class "+className+" {\n";
    if (declList != null) {
      result += declList.toString(1);
    }  
    result += "};\n";
    return result;
  }

  public void processNames() {
    STClassEntry classEntry = new STClassEntry(className + SymbolTable.CLASS_EXTENSION);
    if (SymbolTable.insertName(className + SymbolTable.CLASS_EXTENSION,(STEntry) classEntry)) {
      NameTable cScope = SymbolTable.enterScope();
      classEntry.classScope = cScope;
      for (int i = 0; i < declList.decls.size(); i++) {
        declList.decls.get(i).processNames();
      }
      SymbolTable.exitScope();
    }
  }
}


