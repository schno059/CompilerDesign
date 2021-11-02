import java.util.*;

/**
 * AST node for a program
 */ 
class ProgramAST implements AST {
  IdentAST ident;
  MembersAST members;
  static Node symbolTableTree;

  public ProgramAST() {
    //symbolTable = new LinkedList<String>();
  }

  public ProgramAST(IdentAST i, MembersAST m) {
  	ident = i;
  	members = m;
    //symbolTable = new LinkedList<String>();
  }

  public void checkSymbolTable()
  {
    //ident.checkSymbolTable();
    //members.checkSymbolTable();
    //System.out.println(symbolTable.toString());
    System.out.println("I am gonna check the symbol table");
    symbolTableTree = new Node("Root");
    symbolTableTree.addChild(new Node("Leaf 1"));
    symbolTableTree.addChild(new Node("Leaf 2"));
    symbolTableTree.getChild("Leaf 1").addChild(new Node("The Cool Child"));
    System.out.println(symbolTableTree.toString());
  }

  public void addSymbol(String s)
  {
    //symbolTable.add(s);
    //do something
  }

  public boolean hasBeenDeclared(String s)
  {
    //return symbolTable.contains(s);
    return false;
  }

  public String toString() {
  	if(ident==null)
  		return("");
  	else
    	return("class "+ident+" {"+members+"};");
  }

}

