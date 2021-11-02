import java.util.*; 

class ASTStmtCodeBlock extends ASTStmt {
  ArrayList<ASTDecl> decls;
  ArrayList<ASTStmt> stmts;

  public ASTStmtCodeBlock() {
    decls = new ArrayList<ASTDecl>();
    stmts = new ArrayList<ASTStmt>();
  }

  public void addDecl(ASTDecl d) {
    decls.add(0,d);
  }

  public void addStmt(ASTStmt s) {
    stmts.add(0,s);
  }

  public String toString(int indent) {
    String result = AST.indentString(indent-1) + "{\n";
    
    for (ASTDecl decl : decls) {
      result += decl.toString(indent);
    }
    for (ASTStmt stmt : stmts) {
      result += stmt.toString(indent);
    }
    result += AST.indentString(indent-1) + "}\n";
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    SymbolTable.enterScope();
    for (ASTDecl decl : decls) decl.processNames();
    for (ASTStmt stmt : stmts) stmt.processNames();
    SymbolTable.exitScope();
  }

  public void run() {
    for (ASTDecl decl : decls) {
      decl.run();
    }
    for (ASTStmt stmt : stmts) {
      stmt.run();
    }
  }
}


