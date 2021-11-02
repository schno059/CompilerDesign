/**
 * AST node for a program
 */ 
class ProgramAST implements AST {
  IdentAST ident;
  MembersAST members;

  public ProgramAST() {}

  public ProgramAST(IdentAST i, MembersAST m) {
  	ident = i;
  	members = m;
  }

  public String toString() {
  	if(ident==null)
  		return("");
  	else
    	return("class "+ident+" {"+members+"};");
  }

}

