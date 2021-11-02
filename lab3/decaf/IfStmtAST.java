
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

  public void checkSymbolTable(){
    expression.checkSymbolTable();
    stmts.checkSymbolTable();
    optelse.checkSymbolTable();
    if(expression.typeCheck().equals("BOOL")||expression.typeCheck().equals("INT"))
      System.out.println("If-statement contingent on \'"+expression+"\' which is of type "+expression.typeCheck()+". --> OK");
    else
      ifMismatch(expression);
  }

  public String typeCheck() {return "";}

  public String toString() {
    return("\nif ( "+expression+" )"+stmts+"\n"+optelse+"\n");
  }

}