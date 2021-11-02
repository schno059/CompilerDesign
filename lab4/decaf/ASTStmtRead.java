import java.util.*;
import java.io.IOException;

class ASTStmtRead extends ASTStmt {
  ArrayList<ASTExpr> expressions;

  public ASTStmtRead(ArrayList<ASTExpr> exprs) {
    expressions = exprs;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent) + "read(";
    if ((expressions != null) && (expressions.size() > 0)) {
      result += expressions.get(0).toString();
      if (expressions.size() > 1) {
        for (int i = 1; i < expressions.size(); i++) {
          result = result + "," + expressions.get(i);
        }
      }
    }
    result = result + ");\n";
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    for (ASTExpr expr : expressions) {
      if ((expr instanceof ASTExprVarRef) || (expr instanceof ASTExprArrayRef) ||
          (expr instanceof ASTExprClassArrayRef) || (expr instanceof ASTExprClassFieldRef)) {
        Type t = expr.processNamesTypeCheck();
        if (!(t instanceof TypeBase)) {
          SymbolTable.reportError("Read can not be applied to variables (" + expr.toString() + ") of base types, not " + t.toString());
          return;
        }
      }
      else {
        SymbolTable.reportError("Read can only be applied to variables, not " + expr.toString());
        return;
      }
    }
  }

  public void run() {
    String readString = Main.nextLine();
    String[] splitStrings = readString.split("\\s+");

    if(expressions.size()>splitStrings.length || splitStrings[0].equals("")) {
      Main.error("Warning: insufficient number of arguments for reading "+expressions+". No values have been changed");
    } else {
      for(int i=0; i<expressions.size(); i++) {
        String type = expressions.get(i).typeCheck().toString();
        ASTExprVarRef varCast = (ASTExprVarRef) expressions.get(i);
        if(type.equals("int"))
          varCast.varEntry.exprValue = new ASTExprLitInt(splitStrings[i]);
        else if(type.equals("float"))
          varCast.varEntry.exprValue = new ASTExprLitFloat(splitStrings[i]);
        else if(type.equals("char"))
          varCast.varEntry.exprValue = new ASTExprLitChar(splitStrings[i]);
        else if(type.equals("bool"))
          varCast.varEntry.exprValue = new ASTExprLitBool(splitStrings[i]);
        else
          varCast.varEntry.exprValue = new ASTExprLitString(splitStrings[i]);
      }
    }
  }

}


