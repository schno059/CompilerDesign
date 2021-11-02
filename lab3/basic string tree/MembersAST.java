/**
 * AST node for members
 */ 
class MembersAST extends ProgramAST implements AST {
  FieldsAST fields;
  MethodsAST methods;

  public MembersAST(FieldsAST f, MethodsAST m) {
  	fields = f;
  	methods = m;
  }

  // public void checkSymbolTable()
  // {
  // 	fields.checkSymbolTable();
  // 	methods.checkSymbolTable();
  // }

  public String toString() {
    return("\n\n"+fields+methods+"\n");
  }

}

