
/**
 * AST node for field declaration statements
 */ 
class FieldStmtAST extends StmtAST implements AST {
  FieldsAST fields;
  StmtsAST stmts;
  OptSemiAST optsemi;

  public FieldStmtAST(FieldsAST f, StmtsAST s, OptSemiAST o) {
    fields = f;
    stmts = s;
    optsemi = o;
  }

  public String toString() {
    return("\n{\n"+fields+stmts+"\n}"+optsemi+"\n");
  }

}