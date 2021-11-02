class TypeBase extends Type {
  public int typeNum;
  
  private TypeBase() {}

  public TypeBase(int tn) {
    typeNum = tn;
  }

  public String toString() { return sym.terminalNames[typeNum].toLowerCase(); }

  public boolean typeMatches(Type t2) {
    return ((t2 instanceof TypeBase) && (typeNum == ((TypeBase) t2).typeNum));
  }
};
