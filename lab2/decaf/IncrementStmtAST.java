
/**
 * AST node for increment statements
 */ 
class IncrementStmtAST extends StmtAST implements AST {
  NameAST name;

  public IncrementStmtAST(NameAST n) {
    name = n;
  }

  public String toString() {
    return(""+name+"++;");
  }

}