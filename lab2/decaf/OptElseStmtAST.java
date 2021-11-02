
/**
 * AST node for optional else statements
 */ 
class OptElseStmtAST extends StmtAST implements AST {
  StmtAST stmt;

  public OptElseStmtAST() {}

  public OptElseStmtAST(StmtAST s) {
    stmt = s;
  }

  public String toString() {
    if(stmt==null)
      return("fi");
    else
      return("else\n"+stmt+"\nfi");
  }

}