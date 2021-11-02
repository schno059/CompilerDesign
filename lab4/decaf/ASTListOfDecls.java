import java.util.*;

class ASTListOfDecls extends AST {

  public ArrayList<ASTDecl> decls;

  public ASTListOfDecls() {
    decls = new ArrayList<ASTDecl>();
  }

  public void add(ASTDecl fd) {
    decls.add(0,fd);
  }

  public String toString(int indent) {
    String result = "";
    for (ASTDecl fd : decls)
      result += fd.toString(indent);
    return result;
  }

  public String toString() {
    return toString(1);
  }

}


