class ASTStmt extends AST {

  public String toString(int indent) { return ""; }

  public void processNames() {}

  public void run(){
  	// System.out.println("GENERIC STATEMENT RUNNING");
  }

  public boolean isReturn(){ return false; }

  public ASTExpr returnExpr(){ return null; }

}

