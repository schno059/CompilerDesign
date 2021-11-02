
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

  public String toString() {
    if (printlist == null)
      return(""+expression);
    else
      return(""+expression+" , "+printlist);
  }

}


