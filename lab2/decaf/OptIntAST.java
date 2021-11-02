
/**
 * AST node for optional integer literal
 */ 
class OptIntAST extends StmtAST implements AST {
  IntAST number;

  public OptIntAST() {}

  public OptIntAST(IntAST n) {
  	number = n;
  }

  public String toString() {
  	if(number==null)
    	return("");
    else
    	return(""+number);
  }

}


