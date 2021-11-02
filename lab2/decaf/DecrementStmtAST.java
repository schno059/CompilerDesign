
/**
 * AST node for decrement statements
 */ 
class DecrementStmtAST extends StmtAST implements AST {
  NameAST name;

  public DecrementStmtAST(NameAST n) {
    name = n;
  }

  public String toString() {
    return(""+name+"--;");
  }

}