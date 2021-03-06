/* The following code was generated by JFlex 1.7.0 */

import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>scanner.jflex</tt>
 */
class Yylex implements java_cup.runtime.Scanner, sym {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\1\60\1\56\1\61\1\62\1\60\1\60\22\0\1\60\1\0"+
    "\1\57\3\0\1\11\1\54\1\17\1\20\1\3\1\1\1\15\1\2"+
    "\1\25\1\4\12\53\1\14\1\16\1\5\1\7\1\6\1\13\1\0"+
    "\32\51\1\23\1\55\1\24\1\0\1\52\1\0\1\30\1\42\1\26"+
    "\1\44\1\46\1\37\1\41\1\35\1\32\2\51\1\27\1\51\1\33"+
    "\1\40\1\50\1\51\1\36\1\31\1\34\1\45\1\43\1\47\3\51"+
    "\1\21\1\10\1\22\1\12\6\0\1\62\u1fa2\0\1\62\1\62\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\2\1\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\14\25\1\26"+
    "\1\1\1\27\1\30\1\1\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\4\25\1\41\4\25\1\42"+
    "\5\25\5\0\3\25\1\43\13\25\1\44\1\45\1\46"+
    "\1\25\1\47\1\25\1\50\1\51\3\25\1\52\1\53"+
    "\1\54\2\25\1\55\2\25\1\56\1\57\1\60\1\61"+
    "\1\62\1\63\3\25\1\64";

  private static int [] zzUnpackAction() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\63\0\63\0\314\0\377"+
    "\0\u0132\0\u0165\0\u0198\0\63\0\63\0\63\0\63\0\63"+
    "\0\63\0\63\0\63\0\63\0\63\0\63\0\63\0\u01cb"+
    "\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca\0\u02fd\0\u0330\0\u0363"+
    "\0\u0396\0\u03c9\0\u03fc\0\u042f\0\u0462\0\u0495\0\u04c8\0\u04fb"+
    "\0\63\0\63\0\63\0\63\0\63\0\63\0\63\0\63"+
    "\0\u052e\0\u0561\0\u0594\0\u05c7\0\u01fe\0\u05fa\0\u062d\0\u0660"+
    "\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f\0\u0792\0\u07c5\0\u07f8"+
    "\0\u082b\0\u085e\0\u0891\0\u08c4\0\u08f7\0\u092a\0\u095d\0\u01fe"+
    "\0\u0990\0\u09c3\0\u09f6\0\u0a29\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5"+
    "\0\u0b28\0\u0b5b\0\u0b8e\0\u07f8\0\63\0\63\0\u0bc1\0\u01fe"+
    "\0\u0bf4\0\u01fe\0\u01fe\0\u0c27\0\u0c5a\0\u0c8d\0\u01fe\0\u01fe"+
    "\0\u01fe\0\u0cc0\0\u0cf3\0\u01fe\0\u0d26\0\u0d59\0\u01fe\0\u01fe"+
    "\0\u01fe\0\u0d8c\0\u01fe\0\u01fe\0\u0dbf\0\u0df2\0\u0e25\0\u01fe";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\2\31"+
    "\1\32\1\33\1\31\1\34\1\31\1\35\1\36\2\31"+
    "\1\37\1\40\2\31\1\41\1\42\1\43\1\31\1\2"+
    "\1\44\1\45\1\46\1\47\1\50\2\47\65\0\1\51"+
    "\63\0\1\52\66\0\1\53\1\54\62\0\1\55\62\0"+
    "\1\56\63\0\1\57\63\0\1\60\77\0\1\31\1\61"+
    "\5\31\1\62\16\31\35\0\26\31\35\0\6\31\1\63"+
    "\17\31\35\0\5\31\1\64\3\31\1\65\14\31\35\0"+
    "\10\31\1\66\15\31\35\0\20\31\1\67\5\31\35\0"+
    "\1\31\1\70\1\71\1\31\1\72\21\31\35\0\12\31"+
    "\1\73\13\31\35\0\12\31\1\74\13\31\35\0\1\31"+
    "\1\75\24\31\35\0\7\31\1\76\16\31\35\0\10\31"+
    "\1\77\15\31\34\0\1\100\25\0\1\44\7\0\55\101"+
    "\1\102\1\0\2\101\1\0\1\101\61\46\1\0\1\46"+
    "\56\0\1\47\1\0\2\47\1\0\55\103\1\104\2\0"+
    "\1\103\1\0\1\103\26\0\2\31\1\105\23\31\35\0"+
    "\2\31\1\106\23\31\35\0\10\31\1\107\15\31\35\0"+
    "\6\31\1\110\17\31\35\0\17\31\1\111\6\31\35\0"+
    "\2\31\1\112\3\31\1\113\17\31\35\0\12\31\1\114"+
    "\13\31\35\0\1\31\1\115\24\31\35\0\5\31\1\116"+
    "\20\31\35\0\12\31\1\117\13\31\35\0\4\31\1\120"+
    "\21\31\35\0\3\31\1\121\22\31\35\0\4\31\1\122"+
    "\21\31\35\0\4\31\1\123\21\31\62\0\1\124\63\0"+
    "\1\125\41\0\2\101\17\0\2\101\5\0\55\103\1\104"+
    "\1\0\1\126\1\103\1\0\1\103\33\0\2\103\20\0"+
    "\1\103\1\0\1\103\31\0\3\31\1\127\22\31\35\0"+
    "\10\31\1\130\15\31\35\0\4\31\1\131\21\31\35\0"+
    "\20\31\1\132\5\31\35\0\16\31\1\133\7\31\35\0"+
    "\17\31\1\134\6\31\35\0\2\31\1\135\23\31\35\0"+
    "\3\31\1\111\22\31\35\0\2\31\1\136\23\31\35\0"+
    "\1\31\1\137\24\31\35\0\16\31\1\140\7\31\35\0"+
    "\20\31\1\141\5\31\35\0\1\31\1\142\24\31\35\0"+
    "\5\31\1\143\20\31\35\0\3\31\1\144\22\31\35\0"+
    "\5\31\1\145\20\31\35\0\10\31\1\146\15\31\35\0"+
    "\6\31\1\147\17\31\35\0\1\31\1\150\24\31\35\0"+
    "\20\31\1\151\5\31\35\0\6\31\1\152\17\31\35\0"+
    "\13\31\1\153\12\31\35\0\5\31\1\154\20\31\35\0"+
    "\1\31\1\155\24\31\35\0\4\31\1\156\21\31\35\0"+
    "\5\31\1\157\20\31\35\0\20\31\1\160\5\31\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3672];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\2\11\5\1\14\11\21\1\10\11"+
    "\17\1\5\0\20\1\2\11\32\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[112];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */

  private Symbol sym(int sym) {
    return new Symbol(sym,yyline,yycolumn);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym,yyline,yycolumn,val);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 172) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return sym(EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Unexpected character ["+yytext()+"]");
            } 
            // fall through
          case 53: break;
          case 2: 
            { return sym(PLUS);
            } 
            // fall through
          case 54: break;
          case 3: 
            { return sym(MINUS);
            } 
            // fall through
          case 55: break;
          case 4: 
            { return sym(TIMES);
            } 
            // fall through
          case 56: break;
          case 5: 
            { return sym(DIV);
            } 
            // fall through
          case 57: break;
          case 6: 
            { return sym(LESSTHAN);
            } 
            // fall through
          case 58: break;
          case 7: 
            { return sym(GREATERTHAN);
            } 
            // fall through
          case 59: break;
          case 8: 
            { return sym(ASSIGN);
            } 
            // fall through
          case 60: break;
          case 9: 
            { return sym(LNOT);
            } 
            // fall through
          case 61: break;
          case 10: 
            { return sym(QMARK);
            } 
            // fall through
          case 62: break;
          case 11: 
            { return sym(COLON);
            } 
            // fall through
          case 63: break;
          case 12: 
            { return sym(COMMA);
            } 
            // fall through
          case 64: break;
          case 13: 
            { return sym(SEMI);
            } 
            // fall through
          case 65: break;
          case 14: 
            { return sym(LPAR);
            } 
            // fall through
          case 66: break;
          case 15: 
            { return sym(RPAR);
            } 
            // fall through
          case 67: break;
          case 16: 
            { return sym(LCURLY);
            } 
            // fall through
          case 68: break;
          case 17: 
            { return sym(RCURLY);
            } 
            // fall through
          case 69: break;
          case 18: 
            { return sym(LSQUARE);
            } 
            // fall through
          case 70: break;
          case 19: 
            { return sym(RSQUARE);
            } 
            // fall through
          case 71: break;
          case 20: 
            { return sym(PERIOD);
            } 
            // fall through
          case 72: break;
          case 21: 
            { return sym(IDENT,yytext());
            } 
            // fall through
          case 73: break;
          case 22: 
            { return sym(INTLIT,yytext());
            } 
            // fall through
          case 74: break;
          case 23: 
            { /* one-line comment */
            } 
            // fall through
          case 75: break;
          case 24: 
            { /* eat whitespace */
            } 
            // fall through
          case 76: break;
          case 25: 
            { return sym(INCREMENT);
            } 
            // fall through
          case 77: break;
          case 26: 
            { return sym(DECREMENT);
            } 
            // fall through
          case 78: break;
          case 27: 
            { return sym(NOTEQUAL);
            } 
            // fall through
          case 79: break;
          case 28: 
            { return sym(LESSEQUAL);
            } 
            // fall through
          case 80: break;
          case 29: 
            { return sym(GREATEREQUAL);
            } 
            // fall through
          case 81: break;
          case 30: 
            { return sym(EQUALEQUAL);
            } 
            // fall through
          case 82: break;
          case 31: 
            { return sym(LOR);
            } 
            // fall through
          case 83: break;
          case 32: 
            { return sym(LAND);
            } 
            // fall through
          case 84: break;
          case 33: 
            { return sym(IF);
            } 
            // fall through
          case 85: break;
          case 34: 
            { return sym(FI);
            } 
            // fall through
          case 86: break;
          case 35: 
            { return sym(INT);
            } 
            // fall through
          case 87: break;
          case 36: 
            { return sym(FLOATLIT,yytext());
            } 
            // fall through
          case 88: break;
          case 37: 
            { return sym(CHARLIT,yytext());
            } 
            // fall through
          case 89: break;
          case 38: 
            { return sym(STRINGLIT,yytext());
            } 
            // fall through
          case 90: break;
          case 39: 
            { return sym(CHAR);
            } 
            // fall through
          case 91: break;
          case 40: 
            { return sym(BOOLLIT,yytext());
            } 
            // fall through
          case 92: break;
          case 41: 
            { return sym(READ);
            } 
            // fall through
          case 93: break;
          case 42: 
            { return sym(BOOL);
            } 
            // fall through
          case 94: break;
          case 43: 
            { return sym(VOID);
            } 
            // fall through
          case 95: break;
          case 44: 
            { return sym(ELSE);
            } 
            // fall through
          case 96: break;
          case 45: 
            { return sym(CLASS);
            } 
            // fall through
          case 97: break;
          case 46: 
            { return sym(FLOAT);
            } 
            // fall through
          case 98: break;
          case 47: 
            { return sym(FINAL);
            } 
            // fall through
          case 99: break;
          case 48: 
            { return sym(WHILE);
            } 
            // fall through
          case 100: break;
          case 49: 
            { return sym(PRINT);
            } 
            // fall through
          case 101: break;
          case 50: 
            { return sym(STRING);
            } 
            // fall through
          case 102: break;
          case 51: 
            { return sym(RETURN);
            } 
            // fall through
          case 103: break;
          case 52: 
            { return sym(PRINTLINE);
            } 
            // fall through
          case 104: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
