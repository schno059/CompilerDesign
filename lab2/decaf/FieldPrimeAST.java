
/**
 * AST node for field prime
 */ 
class FieldPrimeAST extends FieldAST implements AST {
  OptExprAST optexpression;
  OptIntAST number;

  public FieldPrimeAST(OptExprAST e) {
    optexpression = e;
  }

  public FieldPrimeAST(OptIntAST n) {
    number = n;
  }

  public String toString() {
    if(number==null)
      return(""+optexpression+";");
    else
      return("["+number+"];");
  }

}


