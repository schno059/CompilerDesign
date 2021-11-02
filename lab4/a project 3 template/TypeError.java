class TypeError extends Type {
  
  public TypeError() {
  }

  public String toString() { return "TYPE_ERROR"; }

  public boolean typeMatches(Type t2) { return false; }
};
