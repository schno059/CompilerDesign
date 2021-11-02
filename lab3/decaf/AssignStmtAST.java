
/**
 * AST node for assignment statements
 */ 
class AssignStmtAST extends StmtAST implements AST {
  NameAST name;
  ExprAST expression;

  public AssignStmtAST(NameAST n, ExprAST e) {
    name = n;
    expression = e;
  }

  public void checkSymbolTable()
  {
    name.checkSymbolTable();
  	expression.checkSymbolTable();
    validateAssignment(name, expression);
  }

  public String typeCheck() {return "";}

  public String toString() {
    return(name+" = "+expression+";");
  }

}


