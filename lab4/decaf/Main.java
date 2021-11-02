import java.io.*;
import java.util.*;

public class Main {
  static List<String> inputList;
  static int inputIndex;

  public static void main(String [] args) throws Exception {
    Reader reader = null;
    
    if (args.length == 1) {
      File input = new File(args[0]);
      if (!input.canRead()) {
        System.out.println("Error: could not read ["+input+"]");
      }
      reader = new FileReader(input);
    }
    else {  
     reader = new InputStreamReader(System.in);
    }

    Yylex scanner = new Yylex(reader);   // create scanner

    parser parser = new parser(scanner); // create parser
    ASTClass program = null;

    try { 
      program = (ASTClass) parser.parse().value;  // parse
    }    
    catch (Exception e) { 
      e.printStackTrace(); 
    }

    System.out.print(program);

    SymbolTable.initialize();
    program.processNames();
    SymbolTable.dumpSymbolTable();

    System.out.println("---------------------------------------------------- (input.txt)"); //line for formatting

    inputList = new ArrayList<String>();
    inputIndex = -1;

    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    	String sCurrentLine;
    	while ((sCurrentLine = br.readLine()) != null)
    		inputList.add(sCurrentLine);
    } catch (IOException e) {
    	e.printStackTrace();
    }

    for(String s: inputList) //prints off the contents of "input.txt"
    	System.out.println(s);

    System.out.println("---------------------------------------------------- (OUTPUT)"); //line for formatting
    program.run();
  }

  public static void error(String s) { 
    System.out.println(s); 
  }

  public static String nextLine() {
  	inputIndex++;
  	if(inputIndex<inputList.size())
  		return inputList.get(inputIndex);
  	else
  		return "";
  }
}
