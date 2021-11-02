/**
 * AST node for a number
 */ 
class FloatAST extends ExprAST implements AST {
  Double number;

  public FloatAST(String s) {
    try { number = Double.parseDouble(s); }
    catch (NumberFormatException e) { number = Double.NaN; };
  }

  public void checkSymbolTable(){}

  public String typeCheck()
  {
  	return "FLOAT";
  }

  public String toString() {
    return(""+String.format("%.2f",number)); 
  }

}