/**
 * AST node for a character
 */ 
class CharAST extends ExprAST implements AST {
  String character;

  public CharAST(String c) {
  	character = c;
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
  	return "CHAR";
  }

  public String toString() {
    return(""+character); 
  }

}

