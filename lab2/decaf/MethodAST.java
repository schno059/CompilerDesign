/**
 * AST node for method
 */ 
class MethodAST implements AST {
  TypeAST type;
  IdentAST ident;
  ArgDeclsAST args;
  FieldsAST fields;
  StmtsAST stmts;
  OptSemiAST optsemi;

  public MethodAST(IdentAST i, ArgDeclsAST a, FieldsAST f, StmtsAST s, OptSemiAST o) {
  	ident = i;
  	args = a;
  	fields = f;
  	stmts = s;
  	optsemi = o;
  }

  public MethodAST(TypeAST t, IdentAST i, ArgDeclsAST a, FieldsAST f, StmtsAST s, OptSemiAST o) {
  	type = t;
  	ident = i;
  	args = a;
  	fields = f;
  	stmts = s;
  	optsemi = o;
  }

  public String toString() {
  	if(type==null)
  		return("void "+ident+"("+args+") {\n\n"+fields+""+stmts+"\n\n} "+optsemi);
  	else
    	return(""+type+" "+ident+"("+args+") {\n\n"+fields+""+stmts+"\n\n} "+optsemi);
  }

}

