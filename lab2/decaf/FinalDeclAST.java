
/**
 * AST node for final field declaration
 */ 
class FinalDeclAST extends FieldAST implements AST {
  TypeAST type;
  IdentAST ident;
  OptExprAST optexpression;

  public FinalDeclAST(TypeAST t, IdentAST i, OptExprAST e) {
    type = t;
    ident = i;
    optexpression = e;
  }

  public String toString() {
    return("final "+type+" "+ident+" "+optexpression+";");
  }

}


