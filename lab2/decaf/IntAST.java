/**
 * AST node for a number
 */ 
class IntAST extends ExprAST implements AST {
  Integer number;

  public IntAST(String s) {
  	number = Integer.parseInt(s);
  }

  public String toString() {
    return(""+number); 
  }

}

