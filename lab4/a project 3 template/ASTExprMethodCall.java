import java.util.*;

class ASTExprMethodCall extends ASTExpr {
  String className;
  String methodName;
  ArrayList<ASTExpr> arguments;
  STClassEntry classSTE;
  STMethodDeclEntry methodSTE;

  public ASTExprMethodCall(String mname, ArrayList<ASTExpr> args) {
    className = null;
    methodName = mname;
    arguments = args;
    classSTE = null;
    methodSTE = null;
  }

  public ASTExprMethodCall(String cname, String mname, ArrayList<ASTExpr> args) {
    className = cname;
    methodName = mname;
    arguments = args;
  }

  public String toString() {
    String result = ((className == null) ? "" : (className + ".")) + methodName + "(";
    if ((arguments != null) && (arguments.size() > 0)) {
      result += arguments.get(0).toString();
      if (arguments.size() > 1) {
        for (int i = 1; i < arguments.size(); i++) {
          result = result + "," + arguments.get(i);
        }
      }
    }
    result = result + ")";
    return result;
  }

  public Type processNamesTypeCheck() {
    if (className == null) {
      STEntry findSTE = SymbolTable.findName(methodName + SymbolTable.METHOD_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Method " + methodName + " undeclared");
        return new TypeError();
      }
      methodSTE = (STMethodDeclEntry) findSTE;
    }
    else {
      STEntry findSTE = SymbolTable.findName(className + SymbolTable.CLASS_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Class " + className + " for method " + methodName + " not declared");
        return new TypeError();
      }
      classSTE = (STClassEntry) findSTE;
      findSTE = classSTE.classScope.findName(methodName + SymbolTable.METHOD_EXTENSION);
      if (findSTE == null) {
        SymbolTable.reportError("Method " + methodName + " not declared in class " + className);
        return new TypeError();
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
        return methodSTE.methodType.returnType;
      else {
        TypeMethod newTm = new TypeMethod(methodSTE.methodType.returnType,argTypes);
        SymbolTable.reportError("Type of method call to function " + methodName + ": " + newTm.toString() + " does not match function type: " + methodSTE.methodType.toString());
      }
    }
    return new TypeError();
  }
}


