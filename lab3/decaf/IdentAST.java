/**
 * AST node for an identifier
 */ 
class IdentAST extends ExprAST implements AST {
  String name;                

  public IdentAST(String s) {
    name = s; 
  }

  public String toString() {
    return name; 
  }

}


