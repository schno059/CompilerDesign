import java.util.*;

class ASTStmtMethodCall extends ASTStmt {
  String className;
  String methodName;
  ArrayList<ASTExpr> arguments;
  STClassEntry classSTE;
  STMethodDeclEntry methodSTE;

  public ASTStmtMethodCall(String mname, ArrayList<ASTExpr> args) {
    className = null;
    methodName = mname;
    arguments = args;
    classSTE = null;
  }

  public ASTStmtMethodCall(String cname, String mname, ArrayList<ASTExpr> args) {
    className = cname;
    methodName = mname;
    arguments = args;
    classSTE = null;
  }

  public String toString(int indent) {
    String result = AST.indentString(indent) + ((className == null) ? "" : (className + ".")) + methodName + "(";
    if ((arguments != null) && (arguments.size() > 0)) {
      result += arguments.get(0).toString();
      if (arguments.size() > 1) {
        for (int i = 1; i < arguments.size(); i++) {
          result = result + "," + arguments.get(i);
        }
      }
    }
    result = result + ");\n";
    return result;
  }

  public String toString() {
    return toString(1);
  }

  public void processNames() {
    if (className == null) {
      STEntry findSTE = SymbolTable.findName(methodName + SymbolTable.METHOD_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Method " + methodName + " undeclared");
        return;
      }
      methodSTE = (STMethodDeclEntry) findSTE;
    }
    else {
      STEntry findSTE = SymbolTable.findName(className + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Class " + className + " for method " + methodName + " not declared");
        return;
      }
      classSTE = (STClassEntry) findSTE;
      findSTE = classSTE.classScope.findName(methodName + SymbolTable.METHOD_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Method " + methodName + " not declared in class " + className);
        return;
      }
      methodSTE = (STMethodDeclEntry) findSTE;
    }
    ArrayList<Type> argTypes = new ArrayList<Type>();
    boolean works = true;
    for (ASTExpr arg : arguments) {
      Type argType = arg.processNamesTypeCheck();
      if (argType instanceof TypeError) works = false;
      argTypes.add(argType);
    }
    if (works) {
      if (methodSTE.methodType.argumentsMatch(argTypes))
        return;
      else {
        TypeMethod newTm = new TypeMethod(methodSTE.methodType.returnType,argTypes);
        SymbolTable.reportError("Type of method call to function " + methodName + ": " + newTm.toString() + " does not match function type: " + methodSTE.methodType.toString());
        return;
      }
    }
    return;
  }


}


