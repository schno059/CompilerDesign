
/**
 * AST node for field declaration
 */ 
class FieldDeclAST extends FieldAST implements AST {
  TypeAST type;
  IdentAST ident;
  FieldPrimeAST fieldprime;

  public FieldDeclAST(TypeAST t, IdentAST i, FieldPrimeAST f) {
    type = t;
    ident = i;
    fieldprime = f;
  }

  public String toString() {
    return(""+type+" "+ident+fieldprime);
  }

}


