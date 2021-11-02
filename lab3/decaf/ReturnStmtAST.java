
/**
 * AST node for return statements
 */ 
class ReturnStmtAST extends StmtAST implements AST {
  ExprAST expression;

  public ReturnStmtAST() {}

  public ReturnStmtAST(ExprAST e) {
    expression = e;
  }

  public void checkSymbolTable()
  {
    if(expression!=null)
      expression.checkSymbolTable();
  }

  public String typeCheck()
  {
    if(expression == null)
      return "VOID";
    else
      return expression.typeCheck();
  }

  public String toString() {
    if (expression == null)
      return("return;");
    else
      return("return "+expression+";");
  }

}