/**
 * AST node for a name
 */ 
class NameAST extends ExprAST implements AST {
  IdentAST ident;
  ExprAST expression;                

  public NameAST(IdentAST i) {
    ident = i; 
  }

  public NameAST(IdentAST i, ExprAST e) {
  	ident = i;
  	expression = e;
  }

  public void checkSymbolTable()
  {
    //Do something
  }

  public String toString() {
    if (expression == null)
      return(""+ident);
    else
      return(""+ident+"["+expression+"]");
  }

}