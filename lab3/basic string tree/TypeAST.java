/**
 * AST node for a type
 */ 
class TypeAST extends ExprAST implements AST {
  String name;                

  public TypeAST(String s) {
    name = s; 
  }

  public String toString() {
    return name; 
  }

}


