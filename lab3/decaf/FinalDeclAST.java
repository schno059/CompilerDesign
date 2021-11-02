
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

  public void checkSymbolTable()
  {
    declare(""+ident,"FINAL_"+type);
    if(optexpression!=null && optexpression.typeCheck()!="")
    {
      optexpression.checkSymbolTable();
      if(coercivelyEquals(type.toString().toUpperCase(), optexpression.typeCheck()))
        System.out.println("\'"+ident+"\' is of type "+type.toString().toUpperCase()+". Declared equal to \'"+optexpression+"\' which is of type \'"+optexpression.typeCheck()+"\'. --> OK");
      else
        typeMismatch("\'"+ident+"\' is of type "+type.toString().toUpperCase()+". Declared equal to \'"+optexpression+"\' which is of type \'"+optexpression.typeCheck()+"\'. Not coercible");
    }
  }

  public String toString() {
    return("final "+type+" "+ident+" "+optexpression+";");
  }

}


