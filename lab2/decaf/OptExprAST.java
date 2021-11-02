
/**
 * AST node for optional expression
 */ 
class OptExprAST extends StmtAST implements AST {
  ExprAST expression;

  public OptExprAST() {}

  public OptExprAST(ExprAST e) {
    expression = e;
  }

  public String toString() {
  	if(expression==null)
  		return("");
  	else
    	return("= "+expression);
  }

}


