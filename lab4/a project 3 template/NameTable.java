import java.util.*;

class NameTable {
  public static int globalScopeNumber = 0;
  public int scopeNumber;
  public int scopeLevel;
  public NameTable enclosingScope;
  public ArrayList<STEntry> entries;
  public HashMap<String,STEntry> hashTable;

  public NameTable(int sl, NameTable es) {
    scopeNumber = globalScopeNumber;
    globalScopeNumber++;
    scopeLevel = sl;
    enclosingScope = es;
    entries = new ArrayList<STEntry>();
    hashTable = new HashMap<String,STEntry>();
  }

  public boolean insertName(String nm, STEntry ste) {
    if (hashTable.containsKey(nm)) {
      return false;
    }
    else {
      hashTable.put(nm,ste);
      entries.add(ste);
      return true;
    }
  }

  public STEntry findName(String n) {
    return hashTable.get(n);
  }

  public String toString() {
    String result = "NameTable(" + Integer.toString(scopeNumber) + ")\nScopeLevel: " + Integer.toString(scopeLevel) + "\n";
    for (STEntry entry : entries)
      result += entry.toString();

    return result;
  }
   
};
  
