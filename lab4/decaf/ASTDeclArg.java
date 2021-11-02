import java.util.*;

class ASTDeclArg extends ASTDecl {

  Integer typeNum;
  String argName;
  Boolean isArray;
  String typeName;

  public ASTDeclArg(Integer tnum, String aname, Boolean isarr) {
    typeNum = tnum;
    argName = aname;
    isArray = isarr;
    typeName = null;
  }

  public ASTDeclArg(String tname, String aname, Boolean isarr) {
    typeName = tname;
    argName = aname;
    isArray = isarr;
    typeNum = null;
  }

  public String toString() {
    return "" + ((typeNum == null) ? typeName : sym.terminalNames[typeNum].toLowerCase()) + " " + argName + (isArray ? "[]" : "");
  }

  public Type processNamesTypeCheck() {
    Type argType = null;
    if (typeName == null) {
      if (isArray) {
        argType = new TypeArray(null,((Type) new TypeBase(typeNum)));
      }
      else {
        argType = new TypeBase(typeNum);
      }
      STEntry newSTE = new STVarDeclEntry(argName,false,argType,null);
      if (!SymbolTable.insertName(argName,newSTE)) {
        SymbolTable.reportError("Argument " + argName + " multiply declared");
        argType = new TypeError();
      }
    }
    else {
      STEntry findSTE = SymbolTable.findName(typeName + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Unable to find class " + typeName + " for argument " + argName + "(looking for " + typeName + SymbolTable.CLASS_EXTENSION + ")");
        argType = new TypeError();
      }
      else {
        if (isArray) {
          argType = new TypeArray(null,((Type) new TypeClass(typeName,findSTE)));
        }
        else {
          argType = new TypeClass(typeName,findSTE);
        }
        STEntry newSTE =  new STVarDeclEntry(argName,false,argType,null);
        if (!SymbolTable.insertName(argName,newSTE)) {
          SymbolTable.reportError("Argument " + argName + " multiply declared");
          argType = new TypeError();
        }
      }
    }
    return argType;
  }

  public void run() {
    // System.out.println("ARGUMENT DECLARATION RUNNING");
  }
}
