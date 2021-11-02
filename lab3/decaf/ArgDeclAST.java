
/**
 * AST node for argument declaration
 */ 
class ArgDeclAST extends StmtAST implements AST {
  TypeAST type;
  IdentAST ident;
  OptBracsAST optbracs;

  public ArgDeclAST(TypeAST t, IdentAST i, OptBracsAST o) {
    type = t;
    ident = i;
    optbracs = o;
  }

  public void checkSymbolTable()
  {
    declare(""+ident,""+type+optbracs);
  }

  public String typeCheck()
  {
    return ""+type;
  }

  public String toString() {
    return(""+type+" "+ident+optbracs);
  }

}


