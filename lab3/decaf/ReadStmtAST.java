
/**
 * AST node for read statements
 */ 
class ReadStmtAST extends StmtAST implements AST {
  ReadListAST readlist;

  public ReadStmtAST(ReadListAST r) {
    readlist = r;
  }

  public void checkSymbolTable(){
  	if(readlist.isValid())
  		System.out.println("Readlist \'"+readlist+"\' is valid. --> OK");
  	else
  		typeMismatch("Readlist \'"+readlist+"\' contains invalid elements");
  }

  public String typeCheck() {return "";}

  public String toString() {
    return("read ( "+readlist+" );");
  }

}