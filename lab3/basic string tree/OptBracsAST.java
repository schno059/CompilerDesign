
/**
 * AST node for optional square brackets
 */ 
class OptBracsAST extends StmtAST implements AST {
  String brackets;

  public OptBracsAST() {}

  public OptBracsAST(String b) {
  	brackets = b;
  }

  public String toString() {
  	if(brackets==null)
    	return("");
    else
    	return(brackets);
  }

}


