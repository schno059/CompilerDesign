
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

  public boolean isValid()
  {
    if(readlist!=null && !readlist.isValid())
    {
      return false;
    }
    if(name == null)
    {
      return true;
    }
    else
    {
      String s = name.typeCheck();

      System.out.println(s);
      if(s.length()>4)
        System.out.println(s.substring(0, 4));

      if(s.length()>4&&s.substring(0, 4).equals("FN_("))
        return false;
      else if(s.length()>2&&s.substring(s.length()-2, s.length()).equals("[]"))
        return false;
      else
        return true;
    }
  }

  public String toString() {
    if (readlist == null)
      return(""+name);
    else
      return(""+name+" , "+readlist);
  }

}


