
/**
 * AST node for print statements
 */ 
class PrintStmtAST extends StmtAST implements AST {
  PrintListAST printlist;

  public PrintStmtAST(PrintListAST p) {
    printlist = p;
  }

  public String toString() {
    return("print ( "+printlist+" );");
  }

}