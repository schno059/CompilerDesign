/**
 * AST node for an identifier
 */ 
class IdentAST extends ExprAST implements AST {
  String name;                

  public IdentAST(String s) {
    name = s; 
  }

  // public void checkSymbolTable()
  // {
  // 	System.out.println("I am checking the IdentAST");
  // }

  public String toString() {
    return name; 
  }

}


