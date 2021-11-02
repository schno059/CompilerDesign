/**
 * AST node for return type
 */ 
class ReturnTypeAST extends ProgramAST implements AST {
  TypeAST type;

  public ReturnTypeAST() {}

  public ReturnTypeAST(TypeAST t) {
  	type = t;
  }

  public String toString() {
    if(type==null)
      return("void");
    else
      return(""+type);
  }

}

