class AST {
  public String toString() { return "error - using AST toString method"; }
  public static String indentString(int n) {
    String result = "";
    for (int i = 0; i < n; i++) result += "  ";
    return result;
  }
  public void processNames() { }

  public boolean isIntType(Type t) {
    return ((t instanceof TypeBase) && (((TypeBase) t).typeNum == sym.INT));
  }

  public boolean isFloatType(Type t) {
    return ((t instanceof TypeBase) && (((TypeBase) t).typeNum == sym.FLOAT));
  }

  public boolean isStringType(Type t) {
    return ((t instanceof TypeBase) && (((TypeBase) t).typeNum == sym.STRING));
  }

  public boolean isCharType(Type t) {
    return ((t instanceof TypeBase) && (((TypeBase) t).typeNum == sym.CHAR));
  }

  public boolean isBoolType(Type t) {
    return ((t instanceof TypeBase) && (((TypeBase) t).typeNum == sym.BOOL));
  }

}


