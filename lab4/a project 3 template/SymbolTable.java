import java.util.*;

class SymbolTable {
  public static int currentLevel;
  public static NameTable topTable;
  public static NameTable globalScope;
  public static ArrayList<ArrayList<NameTable>> tableTable;
  public static final String CLASS_EXTENSION = ":class";
  public static final String METHOD_EXTENSION = ":method";
  public static int numSTErrors = 0;
  public static STMethodDeclEntry currentMethod = null;

  public static void initialize() {
    currentLevel = 0;
    topTable = new NameTable(currentLevel,null);
    globalScope = topTable;
    tableTable = new ArrayList<ArrayList<NameTable>>();
    tableTable.add(0,new ArrayList<NameTable>());
    tableTable.get(0).add(topTable);
  }

  public static NameTable enterScope() {
    currentLevel++;
    while (currentLevel >= tableTable.size()) {
      tableTable.add(new ArrayList<NameTable>());
    }
    topTable = new NameTable(currentLevel,topTable);
    tableTable.get(currentLevel).add(topTable); 
    return topTable;
  }

  public static void exitScope() {
    currentLevel--;
    topTable = topTable.enclosingScope;
  }
  
  public static boolean insertName(String nm,STEntry ste) {
    return topTable.insertName(nm,ste);
  }

  public static boolean insertNameIntoEnclosingScope(String nm,STEntry ste) {
    if (topTable.enclosingScope == null) return false;
    return topTable.enclosingScope.insertName(nm,ste);
  }

  public static STEntry findName(String n) {
    NameTable t = topTable;
    while (t != null) {
      STEntry e = t.findName(n);
      if (e != null) return e;
      t = t.enclosingScope;
    }
    return null;
  }

  public static void showStack() {
    System.out.println("Current stack:");
    NameTable nt = topTable;
    while (nt != null) {
      System.out.println(nt.toString());
      nt = nt.enclosingScope;
    }
  }

  public static void dumpSymbolTable() {
    System.out.println("\n");
    for (ArrayList<NameTable> levelTables : tableTable) {
      for (NameTable table : levelTables)
        System.out.println(table.toString());
    }
  }

  public static void reportError(String s) {
    numSTErrors++;
    System.err.println("ERROR: " + s);
  }

  public static STMethodDeclEntry getCurrentMethod() {
    return currentMethod;
  }

  public static void setCurrentMethod(STMethodDeclEntry cm) {
    currentMethod = cm;
  }

  public static void clearCurrentMethod() {
    currentMethod = null;
  }
};
