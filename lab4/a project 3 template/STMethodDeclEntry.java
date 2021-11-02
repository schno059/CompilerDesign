import java.util.*;

class STMethodDeclEntry extends STEntry {
  public TypeMethod methodType;
  public ArrayList<ASTStmt> stmts;
  public NameTable methodScope;

  public STMethodDeclEntry(String nm, TypeMethod mt, ArrayList<ASTStmt> sl, NameTable ms) {
    name = nm;
    methodType = mt;
    stmts = sl;
    methodScope = ms;
  }
    
  public String toString() {
    String result = "  method: " + name + " type: " + methodType.toString() + " scope# " + methodScope.scopeNumber + "\n    statements:\n";
    for (ASTStmt stmt : stmts)
      result += stmt.toString(3);
    return result;
  }
};
