import java.util.*;

class STVarDeclEntry extends STEntry {
  public boolean finalVar;
  public Type varType;
  public ASTExpr exprValue;

  public STVarDeclEntry(String nm, boolean fin, Type typ, ASTExpr ev) {
    name = nm;
    finalVar = fin;
    varType = typ;
    exprValue = ev;
  }
    
  public String toString() {
    return "  variable: " + name + " type: " + varType.toString() + " initialvalue: " + ((exprValue == null) ? "none" : exprValue.toString()) + (finalVar ? " final" : "") + "\n";
  }
};
