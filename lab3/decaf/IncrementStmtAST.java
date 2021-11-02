
/**
 * AST node for increment statements
 */ 
class IncrementStmtAST extends StmtAST implements AST {
  NameAST name;

  public IncrementStmtAST(NameAST n) {
    name = n;
  }

  public void checkSymbolTable(){
  	String type = use(name);
  	if(type.equals("FLOAT")||type.equals("INT"))
  		System.out.println("Incrementing \'"+name+"\' which is of type "+type+". --> OK");
  	else
  		typeMismatch("Attempted to increment \'"+name+"\' which is of type "+type+". Acceptable types are [INT, FLOAT]");
  }

  public String typeCheck() {return "";}

  public String toString() {
    return(""+name+"++;");
  }

}