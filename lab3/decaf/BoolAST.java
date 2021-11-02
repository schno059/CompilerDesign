/**
 * AST node for a boolean
 */ 
class BoolAST extends ExprAST implements AST {
  String string;

  public BoolAST(String s) {
  	string = s;
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
  	return "BOOL";
  }

  public String toString() {
    return(string); 
  }

}

