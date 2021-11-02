
/**
 * AST node for optional expression
 */ 
class OptExprAST extends StmtAST implements AST {
  ExprAST expression;

  public OptExprAST() {}

  public OptExprAST(ExprAST e) {
    expression = e;
  }

  public void checkSymbolTable()
  {
    if(expression!=null)
      expression.checkSymbolTable();
  }

  public String typeCheck()
  {
    if(expression==null)
      return "";
    else
      return expression.typeCheck();
  }

  public ExprAST getExpression()
  {
    return expression;
  }

  public String toString() {
  	if(expression==null)
  		return("");
  	else
    	return("= "+expression);
  }

}


