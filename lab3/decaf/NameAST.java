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

  public void checkSymbolTable(){
    if(expression!=null)
    {
      expression.checkSymbolTable();
      if(expression.typeCheck().equals("INT"))
        System.out.println("Index of \'"+ident+"[]\' reducible to INT. --> OK");
      else
        typeMismatch("Attempted to index \'"+ident+"[]\' with \'"+expression+"\' which is not reducible to INT");
    }
  }

  public String typeCheck()
  {
    if(expression==null)
    {
      return use(ident);
    }
    else
    {
      String str = use(ident);
      return str.substring(0, str.length() - 2);
    }
  }

  public String toString() {
    if (expression == null)
      return(""+ident);
    else
      return(""+ident+"["+expression+"]");
  }

}