
/**
 * AST node for print lists
 */ 
class PrintListAST extends StmtAST implements AST {
  ExprAST expression;
  PrintListAST printlist;

  public PrintListAST(ExprAST e) {
    expression = e;
  }

  public PrintListAST(ExprAST e, PrintListAST p) {
    expression = e;
    printlist = p;
  }

  public boolean isValid()
  {
    if(printlist!=null && !printlist.isValid())
    {
      return false;
    }
    if(expression == null)
    {
      return true;
    }
    else
    {
      String s = expression.typeCheck();

      if(s.equalsIgnoreCase("VOID"))
        return false;
      else if(s.length()>2&&s.substring(s.length()-2, s.length()).equals("[]"))
        return false;
      else
        return true;
    }
  }

  public String toString() {
    if (printlist == null)
      return(""+expression);
    else
      return(""+expression+" , "+printlist);
  }

}


