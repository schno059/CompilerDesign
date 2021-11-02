/**
 * AST node for a type expression
 */ 
class TypeExprAST extends ExprAST implements AST {
  TypeAST type;
  ExprAST expression;                

  public TypeExprAST(TypeAST t, ExprAST e) {
  	type = t;
    expression = e; 
  }

  public String toString() {
    return("("+type+") "+expression);
  }

}