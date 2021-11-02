import java.util.*;

class ASTExpr extends AST {
  static HashMap<Integer,String> operatorNames = null;

  static public String getOperatorName(int op) {
    if (operatorNames == null) {
      operatorNames = new HashMap<Integer,String>();
      operatorNames.put(sym.MINUS,"-");
      operatorNames.put(sym.PLUS,"+");
      operatorNames.put(sym.UMINUS,"-");
      operatorNames.put(sym.UPLUS,"+");
      operatorNames.put(sym.TIMES,"*");
      operatorNames.put(sym.DIV,"/");
      operatorNames.put(sym.LESSTHAN,"<");
      operatorNames.put(sym.GREATERTHAN,">");
      operatorNames.put(sym.LESSEQUAL,"<=");
      operatorNames.put(sym.GREATEREQUAL,">=");
      operatorNames.put(sym.EQUALEQUAL,"==");
      operatorNames.put(sym.NOTEQUAL,"<>");
      operatorNames.put(sym.LOR,"||");
      operatorNames.put(sym.LAND,"&&");
      operatorNames.put(sym.LNOT,"~");
    }
    return operatorNames.get(op);
  }

  public Type processNamesTypeCheck() { return new TypeError(); }

  public Type typeCheck() { return processNamesTypeCheck(); }

  public ASTExpr exprValue(){ return this; }

}

