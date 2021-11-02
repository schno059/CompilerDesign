import java.io.*;

public class Main {

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
    ProgramAST program = null;

    try { 
      program = (ProgramAST) parser.parse().value;  // parse
    }    
    catch (Exception e) { 
      e.printStackTrace(); 
    }

    System.out.print("\n"+program+"\n\n");

  }

  public static void error(String s) { 
    System.out.println(s); 
  }
}
