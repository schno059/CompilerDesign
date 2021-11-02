
/**
 * AST node for optional integer literal
 */ 
class OptIntAST extends StmtAST implements AST {
  IntAST number;

  public OptIntAST() {}

  public OptIntAST(IntAST n) {
  	number = n;
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
    return number.typeCheck();
  }

  public String toString() {
  	if(number==null)
    	return("");
    else
    	return(""+number);
  }

}


