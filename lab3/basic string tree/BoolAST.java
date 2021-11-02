/**
 * AST node for a boolean
 */ 
class BoolAST extends ExprAST implements AST {
  String string;

  public BoolAST(String s) {
  	string = s;
  }

  public String toString() {
    return(string); 
  }

}

