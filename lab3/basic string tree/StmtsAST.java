
/**
 * AST node for statement lists
 */ 
class StmtsAST extends StmtAST implements AST {
  StmtAST first;
  StmtsAST rest;

  public StmtsAST() {};

  public StmtsAST(StmtAST f, StmtsAST r) {
    first = f;
    rest = r;
  }

  public String toString() {
    if(first==null)
      return("");
    else
      return("\n"+first+rest);
  }

}


