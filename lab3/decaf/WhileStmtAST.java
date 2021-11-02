
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

  public void checkSymbolTable(){
    expression.checkSymbolTable();
    stmt.checkSymbolTable();
    if(expression.typeCheck().equals("BOOL")||expression.typeCheck().equals("INT"))
      System.out.println("While-statement contingent on \'"+expression+"\' which is of type "+expression.typeCheck()+". --> OK");
    else
      whileMismatch(expression);
  }

  public String typeCheck() {return "";}

  public String toString() {
    return("\nwhile ( "+expression+" )\n"+stmt+"\n");
  }

}