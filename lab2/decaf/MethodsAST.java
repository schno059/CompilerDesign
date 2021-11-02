/**
 * AST node for methods
 */ 
class MethodsAST implements AST {
  MethodAST method;
  MethodsAST methods;

  public MethodsAST() {};

  public MethodsAST(MethodAST m, MethodsAST s) {
  	method = m;
  	methods = s;
  }

  public String toString() {
  	if(method==null)
  		return("");
  	else
    	return("\n\n"+method+"\n\n"+methods);
  }

}

