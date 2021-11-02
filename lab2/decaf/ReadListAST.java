
/**
 * AST node for read lists
 */ 
class ReadListAST extends StmtAST implements AST {
  NameAST name;
  ReadListAST readlist;

  public ReadListAST(NameAST n) {
    name = n;
  }

  public ReadListAST(NameAST n, ReadListAST r) {
    name = n;
    readlist = r;
  }

  public String toString() {
    if (readlist == null)
      return(""+name);
    else
      return(""+name+" , "+readlist);
  }

}


