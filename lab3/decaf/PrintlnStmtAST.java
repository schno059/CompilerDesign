
/**
 * AST node for print statements
 */ 
class PrintlnStmtAST extends StmtAST implements AST {
  PrintlnListAST printlnlist;

  public PrintlnStmtAST(PrintlnListAST p) {
    printlnlist = p;
  }

  public void checkSymbolTable(){}

  public String typeCheck() {return "";}

  public String toString() {
    return("printline ( "+printlnlist+" );");
  }

}