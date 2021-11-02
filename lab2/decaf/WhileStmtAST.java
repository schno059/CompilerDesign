
/**
 * AST node for while statements
 */ 
class WhileStmtAST extends StmtAST implements AST {
  ExprAST expression;
  StmtAST stmt;

  public WhileStmtAST(ExprAST e, StmtAST s) {
    expression = e;
    stmt = s;
  }

  public String toString() {
    return("\nwhile ( "+expression+" )\n"+stmt+"\n");
  }

}