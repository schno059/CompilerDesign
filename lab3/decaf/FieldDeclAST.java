
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

  public void checkSymbolTable()
  {
    declare(""+ident,""+type+fieldprime.getSymbolExtension());
    if(fieldprime!=null)
    {
      fieldprime.checkSymbolTable();
      if(fieldprime.getExpression()==null)
        System.out.println("\'"+ident+"\' declared as type "+type.toString().toUpperCase()+".");
      else if(coercivelyEquals(type.toString().toUpperCase(), fieldprime.typeCheck()))
        System.out.println("\'"+ident+"\' is of type "+type.toString().toUpperCase()+". Declared equal to \'"+fieldprime.getExpression()+"\' which is of type \'"+fieldprime.typeCheck()+"\'. --> OK");
      else
        typeMismatch("\'"+ident+"\' is of type "+type.toString().toUpperCase()+". Declared equal to \'"+fieldprime.getExpression()+"\' which is of type \'"+fieldprime.typeCheck()+"\'. Not coercible");
    }
  }

  public String toString() {
    return(""+type+" "+ident+fieldprime);
  }

}


