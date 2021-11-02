/**
 * AST node for a string
 */ 
class StrAST extends ExprAST implements AST {
  String string;

  public StrAST(String s) {
  	string = s;
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
  	return "STRING";
  }

  public String toString() {
    return(string); 
  }

}

