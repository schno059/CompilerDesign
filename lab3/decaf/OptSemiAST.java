
/**
 * AST node for optional semicolon
 */ 
class OptSemiAST extends StmtAST implements AST {
  String semi;

  public OptSemiAST() {}

  public OptSemiAST(String s) {
  	semi = s;
  }

  public String toString() {
  	if(semi==null)
    	return("");
    else
    	return(semi);
  }

}


