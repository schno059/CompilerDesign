class TypeArray extends Type {
  public Type ofType;
  public Integer size;
  
  private TypeArray() {}

  public TypeArray(Integer sz, Type ot) {
    ofType = ot;
    size = sz;
  }

  public String toString() { return ofType.toString() + "[" + ((size == null) ? "" : size.toString()) + "]"; }

  public boolean typeMatches(Type t2) {
    if (t2 instanceof TypeArray) {
      if ((size == null) || (((TypeArray) t2).size == null) || (size == (((TypeArray) t2).size))) return ofType.typeMatches(((TypeArray) t2).ofType);
    }
    return false;
  }
};
