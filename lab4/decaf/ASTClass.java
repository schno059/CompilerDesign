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

  public void run() {
      ASTDeclMethod mainDecl = null;
      ASTDecl currentDecl = null;
      for (int i = 0; i < declList.decls.size(); i++) {
        currentDecl = declList.decls.get(i);
        currentDecl.run();
        if(currentDecl.isMainMethod())
          mainDecl = (ASTDeclMethod) currentDecl;
      }
      
      if(mainDecl == null)
        Main.error("Error: No valid main method for "+className);
      else
        mainDecl.call();
  }
}


