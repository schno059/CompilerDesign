
/**
 * AST node for if statements
 */ 
class IfStmtAST extends StmtAST implements AST {
  ExprAST expression;
  StmtsAST stmts;
  OptElseStmtAST optelse;

  public IfStmtAST(ExprAST e, StmtsAST s, OptElseStmtAST o) {
    expression = e;
    stmts = s;
    optelse = o;
  }

  public String toString() {
    return("\nif ( "+expression+" )"+stmts+"\n"+optelse+"\n");
  }

}