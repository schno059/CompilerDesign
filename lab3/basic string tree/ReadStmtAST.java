
/**
 * AST node for read statements
 */ 
class ReadStmtAST extends StmtAST implements AST {
  ReadListAST readlist;

  public ReadStmtAST(ReadListAST r) {
    readlist = r;
  }

  public String toString() {
    return("read ( "+readlist+" );");
  }

}