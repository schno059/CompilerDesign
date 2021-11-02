
/**
 * AST node for decrement statements
 */ 
class DecrementStmtAST extends StmtAST implements AST {
  NameAST name;

  public DecrementStmtAST(NameAST n) {
    name = n;
  }

  public void checkSymbolTable(){
  	String type = use(name);
  	if(type.equals("FLOAT")||type.equals("INT"))
  		System.out.println("Decrementing \'"+name+"\' which is of type "+type+". --> OK");
  	else
  		typeMismatch("Attempted to decrement \'"+name+"\' which is of type "+type+". Acceptable types are [INT, FLOAT]");
  }

  public String typeCheck() {return "";}

  public String toString() {
    return(""+name+"--;");
  }

}