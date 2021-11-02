/**
 * AST node for an expression.
 * 
 * The non terminal expression is the sum of multiple variants and
 * therefore modelled as an abstract class.
 * 
 */ 
abstract class ExprAST extends ProgramAST implements AST {
	public String typeCheck(){return "";}
  
}

