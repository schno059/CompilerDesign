/**
 * AST node for a number
 */ 
class IntAST extends ExprAST implements AST {
  Integer number;

  public IntAST(String s) {
  	number = Integer.parseInt(s);
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
  	return "INT";
  }

  public String toString() {
    return(""+number); 
  }

}

