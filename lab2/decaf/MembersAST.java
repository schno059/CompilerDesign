/**
 * AST node for members
 */ 
class MembersAST implements AST {
  FieldsAST fields;
  MethodsAST methods;

  public MembersAST(FieldsAST f, MethodsAST m) {
  	fields = f;
  	methods = m;
  }

  public String toString() {
    return("\n\n"+fields+methods+"\n");
  }

}

