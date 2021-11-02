import java.util.*;

class ASTStmtUpdate extends ASTStmt {
  int operator;
  String className;
  String varName;
  ASTExpr arrayIndex;
  STClassEntry classEntry;
  STVarDeclEntry varEntry;

  public ASTStmtUpdate(int op, String cn, String vn, ASTExpr ai) {
    operator = op;
    className = cn;
    varName = vn;
    arrayIndex = ai;
    classEntry = null;
  }

  public String toString(int indent) {
    return AST.indentString(indent) + ((className == null) ? "" : (className + ".")) + varName + ((arrayIndex == null) ? "" : ("[" + arrayIndex + "]")) + ((operator == sym.INCREMENT) ? "++" : "--") + ";\n";
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    if (className == null) {
      classEntry = null;
      varEntry = (STVarDeclEntry) SymbolTable.findName(varName);
      if (varEntry == null) {
        SymbolTable.reportError("Variable " + varName + " not found for " + ((operator == sym.INCREMENT) ? "++" : "--"));
        return;
      }
    }
    else {
      classEntry = (STClassEntry) SymbolTable.findName(className + SymbolTable.CLASS_EXTENSION);
      if (classEntry == null) {
        SymbolTable.reportError("Class name not found for " + className + " for " + ((operator == sym.INCREMENT) ? "++" : "--") + " to " + varName);
        return;
      }
      varEntry = (STVarDeclEntry) classEntry.classScope.findName(varName);
      if (varEntry == null) {
        SymbolTable.reportError("Field " + varName + " not found in " + className + " for " + ((operator == sym.INCREMENT) ? "++" : "--"));
        return;
      }
    }
    if (arrayIndex == null) {
      if ((isIntType(varEntry.varType)) || (isFloatType(varEntry.varType))) {
      }
      else {
        SymbolTable.reportError("Variable " + varName + " should be of int or float type for " + ((operator == sym.INCREMENT) ? "++" : "--"));
        return;
      }
    }
    else {
      if (varEntry.varType instanceof TypeArray) {
        Type t = (TypeArray) varEntry.varType;
        if (isIntType(t) || isFloatType(t)) {
          Type aType = arrayIndex.processNamesTypeCheck();
          if (!isIntType(aType)) {
            SymbolTable.reportError("Array index for " + varName + " should be of type int for " + arrayIndex.toString());
            return;
          }
        }
        else {
          SymbolTable.reportError("Array element of " + varName + " should be of int or float type for " + ((operator == sym.INCREMENT) ? "++" : "--"));
          return;
        }
      }
      else {
        SymbolTable.reportError("Attempt to apply [] to " + varName + " which is not an array");
        return;
      }
    }
  }

  public void run(){
    System.out.println("ASTStmtUpdate RUNNING");
  }
}


