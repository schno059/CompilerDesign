/**
 * AST node for a character
 */ 
class CharAST extends ExprAST implements AST {
  String character;

  public CharAST(String c) {
  	character = c;
  }

  public String toString() {
    return(""+character); 
  }

}

