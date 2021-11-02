
/**
 * AST node for fields
 */ 
class FieldsAST extends FieldAST implements AST {
  FieldsAST fields;
  FieldAST field;

  public FieldsAST() {}

  public FieldsAST(FieldsAST s, FieldAST f) {
    fields = s;
    field = f;
  }

  public void checkSymbolTable()
  {
    if(fields!=null)
      fields.checkSymbolTable();
    if(field!=null)
      field.checkSymbolTable();
  }

  public String toString() {
  	if(field==null)
  		return("");
  	else
    	return(""+fields+field+"\n");
  }

}


