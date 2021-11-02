
/**
 * AST node for optional else statements
 */ 
class OptElseStmtAST extends StmtAST implements AST {
  StmtAST stmt;

  public OptElseStmtAST() {}

  public OptElseStmtAST(StmtAST s) {
    stmt = s;
  }

  public void checkSymbolTable()
  {
    if(stmt!=null)
      stmt.checkSymbolTable();
  }

  public String toString() {
    if(stmt==null)
      return("fi");
    else
      return("else\n"+stmt+"\nfi");
  }

}