import java.util.*;

class STClassEntry extends STEntry {
  public NameTable classScope;

  public STClassEntry(String nm) {
    name = nm;
    classScope = null;
  }
    
  public String toString() {
    return "  class: " + name + " scope#: " + Integer.toString(classScope.scopeNumber) + "\n";
  }
};
