
/**
 * AST node for assignment statements
 */ 
class AssignStmtAST extends StmtAST implements AST {
  NameAST variable;
  ExprAST expression;

  public AssignStmtAST(NameAST v, ExprAST e) {
    variable = v;
    expression = e;
  }

  public String toString() {
    return(variable+" = "+expression+";");
  }

}


