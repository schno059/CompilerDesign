
/**
 * AST node for print statements
 */ 
class PrintStmtAST extends StmtAST implements AST {
  PrintListAST printlist;

  public PrintStmtAST(PrintListAST p) {
    printlist = p;
  }

  public void checkSymbolTable(){
  	if(printlist.isValid())
  		System.out.println("Printlist \'"+printlist+"\' is valid. --> OK");
  	else
  		typeMismatch("Printlist \'"+printlist+"\' contains invalid elements");
  }

  public String typeCheck() {return "";}

  public String toString() {
    return("print ( "+printlist+" );");
  }

}