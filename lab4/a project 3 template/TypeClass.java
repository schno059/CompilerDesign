class TypeClass extends Type {
  public String typeName;
  public STEntry classEntry;
  
  private TypeClass() {}

  public TypeClass(String tn, STEntry ce) {
    typeName = tn;
    classEntry = ce;
  }

  public String toString() { return typeName + "(" + classEntry.name + ")"; }

  public boolean typeMatches(Type t2) {
    return ((t2 instanceof TypeClass) && (classEntry == ((TypeClass) t2).classEntry));
  }
};
