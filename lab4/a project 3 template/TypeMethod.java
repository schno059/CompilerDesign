import java.util.*;

class TypeMethod extends Type {
  public Type returnType;
  public ArrayList<Type> argTypes;
  
  private TypeMethod() {}

  public TypeMethod(Type rt, ArrayList<Type> ats) {
    returnType = rt;
    argTypes = ats;
  }

  public String toString() { 
    String result = "(";
    if (argTypes.size() > 0) {
      for (int i = 0; i < argTypes.size() - 1; i++)
        result += argTypes.get(i).toString() + "*";
      result += argTypes.get(argTypes.size() - 1).toString();
    }
    result += ")->";
    result += returnType.toString();
    return result;
  }

  public boolean typeMatches(Type t2) {
    if (t2 instanceof TypeMethod) {
      TypeMethod t2a = (TypeMethod) t2;
      if (returnType.typeMatches(t2a.returnType)) {
        if (argTypes.size() == t2a.argTypes.size()) {
          for (int i = 0; i < argTypes.size(); i++)
            if (!argTypes.get(i).typeMatches(t2a.argTypes.get(i)))
              return false;
        }
        else return false;
      }
      else return false;
    }
    else return false;
    return true;
  }

  public boolean argumentsMatch(ArrayList<Type> actualTypes) {
    if (argTypes.size() == actualTypes.size()) {
      boolean matches = true;
      int i = 0;
      while (matches && (i < argTypes.size())) {
        if (argTypes.get(i).typeMatches(actualTypes.get(i)))
          i++;
        else 
          matches = false;
      }
      if (matches) return true;
    }
    return false;
  }
};
