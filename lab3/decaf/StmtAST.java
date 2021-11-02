/**
 * AST node for a program statement
 * 
 * The non terminal stmt is the sum of multiple variants and
 * therefore modelled as an abstract class.
 * 
 */ 
abstract class StmtAST extends ProgramAST implements AST {
	public String typeCheck() {return "";} 
}

