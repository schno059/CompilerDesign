
/**
 * AST node for binary expressions
 */ 
class BinaryExprAST extends ExprAST implements AST {
  ExprAST leftarg, rightarg;
  String operator;

  public BinaryExprAST(ExprAST left, String op, ExprAST right) {
    leftarg = left;
    operator = op;
    rightarg = right;
  }

  public void checkSymbolTable()
  {
    leftarg.checkSymbolTable();
    rightarg.checkSymbolTable();
  }

  public String typeCheck()
  {
    String lt = leftarg.typeCheck();
    String rt = rightarg.typeCheck();

    if(lt.contains(")_"))
      lt = lt.substring(lt.indexOf(")_")+2, lt.length());
    if(rt.contains(")_"))
      rt = rt.substring(rt.indexOf(")_")+2, rt.length());

    if(lt.contains("FINAL_"))
      lt = lt.substring(lt.indexOf("FINAL_")+6, lt.length());
    if(rt.contains("FINAL_"))
      rt = rt.substring(rt.indexOf("FINAL_")+6, rt.length());

    if(lt.equalsIgnoreCase("FLOAT"))
    {
      if(rt.equalsIgnoreCase("FLOAT")||rt.equalsIgnoreCase("INT"))
        if(operator.equals("*")||operator.equals("/")||operator.equals("+")||operator.equals("-"))
          return "FLOAT";
    }
    else if(lt.equalsIgnoreCase("INT"))
    {
      if(operator.equals("*")||operator.equals("/")||operator.equals("+")||operator.equals("-"))
        if(rt.equalsIgnoreCase("FLOAT"))
          return "FLOAT";
        else if(rt.equalsIgnoreCase("INT"))
          return "INT";
    }
    else if(lt.equalsIgnoreCase("STRING")&&rt.equalsIgnoreCase("STRING"))
    {
      if(operator.equals("+"))
        return "STRING";
    }



    if(operator.equals("<")||operator.equals(">")||operator.equals("<=")||operator.equals(">=")||operator.equals("==")||operator.equals("<>"))
    {
      if(coercivelyEquals(lt, rt)||coercivelyEquals(rt, lt))
        return "BOOL";
    }
    else if(operator.equals("||")||operator.equals("&&"))
    {
      if(lt.equalsIgnoreCase("BOOL")&&rt.equalsIgnoreCase("BOOL"))
        return "BOOL";
    }

    typeMismatch("Attempted "+operator+" operation between \'"+leftarg+"\' and \'"+rightarg+"\' which are of incompatible types ["+lt+" and "+rt+"].");
    return "";
  }


  public String toString() {
    return("("+leftarg+" "+operator+" "+rightarg+")"); 
  }

}


