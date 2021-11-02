abstract class ASTDecl extends AST {
  public String toString(int ident) { return "SHOULD NOT HAPPEN"; }
  public void run(){ 
  	System.out.println("GENERIC DECLARATION RUNNING"); 
  }
  public boolean isMainMethod(){ return false; }
}

