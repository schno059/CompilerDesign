/**
 * AST node for methods
 */ 
class MethodsAST extends ProgramAST implements AST {
  MethodAST method;
  MethodsAST methods;

  public MethodsAST() {};

  public MethodsAST(MethodAST m, MethodsAST s) {
  	method = m;
  	methods = s;
  }

  public void checkSymbolTable()
  {
    if(method!=null)
      method.checkSymbolTable();
    if(methods!=null)
      methods.checkSymbolTable();
  }

  public String toString() {
  	if(method==null)
  		return("");
  	else
    	return("\n\n"+method+"\n\n"+methods);
  }

}

