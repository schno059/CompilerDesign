
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

  public void checkSymbolTable()
  {
    if(first!=null)
      first.checkSymbolTable();
    if(rest!=null)
      rest.checkSymbolTable();
  }

  public String typeCheck()
  {
    if(first==null)
      return("");
    else if (rest == null)
      return(""+first.typeCheck());
    else
      if(!first.typeCheck().equals("")&&!rest.typeCheck().equals(""))
        return("Uh oh");//------------------------------------------------------------------------------------
      else if(!first.typeCheck().equals(""))
        return first.typeCheck();
      else
        return rest.typeCheck();
  }

  public String toString() {
    if(first==null)
      return("");
    else
      return("\n"+first+rest);
  }

}


