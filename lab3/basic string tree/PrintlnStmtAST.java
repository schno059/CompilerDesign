
/**
 * AST node for print statements
 */ 
class PrintlnStmtAST extends StmtAST implements AST {
  PrintlnListAST printlnlist;

  public PrintlnStmtAST(PrintlnListAST p) {
    printlnlist = p;
  }

  public String toString() {
    return("printline ( "+printlnlist+" );");
  }

}