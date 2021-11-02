import java_cup.runtime.Symbol;

%%

%cup
%implements sym
%line
%column

%{ 

  private Symbol sym(int sym) {
    return new Symbol(sym,yyline,yycolumn);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym,yyline,yycolumn,val);
  }
%}

%%

"+"             { return sym(PLUS); }
"-"             { return sym(MINUS); }
"+"             { return sym(UPLUS); }
"-"             { return sym(UMINUS); }
"*"             { return sym(TIMES); }
"/"             { return sym(DIV); }
"<"             { return sym(LESSTHAN); }
">"             { return sym(GREATERTHAN); }
"<="            { return sym(LESSEQUAL); }
">="            { return sym(GREATEREQUAL); }
"=="            { return sym(EQUALEQUAL); }
"<>"            { return sym(NOTEQUAL); }
"||"            { return sym(LOR); }
"&&"            { return sym(LAND); }
"~"             { return sym(LNOT); }
"?"             { return sym(QMARK); }
":"             { return sym(COLON); }
"="             { return sym(ASSIGN); }
","             { return sym(COMMA); }
";"             { return sym(SEMI); }
"("             { return sym(LPAR); }
")"             { return sym(RPAR); }
"{"             { return sym(LCURLY); }
"}"             { return sym(RCURLY); }
"["             { return sym(LSQUARE); }
"]"             { return sym(RSQUARE); }
"."             { return sym(PERIOD); }
"++"            { return sym(INCREMENT); }
"--"            { return sym(DECREMENT); }
"class"         { return sym(CLASS); }
"int"           { return sym(INT); }
"char"          { return sym(CHAR); }
"float"         { return sym(FLOAT); }
"string"        { return sym(STRING); }
"bool"          { return sym(BOOL); }
"void"          { return sym(VOID); }
"true"          { return sym(BOOLLIT,yytext()); }
"false"         { return sym(BOOLLIT,yytext()); }
"final"         { return sym(FINAL); }
"if"            { return sym(IF); }
"else"          { return sym(ELSE); }
"fi"            { return sym(FI); }
"while"         { return sym(WHILE); }
"return"        { return sym(RETURN); }
"print"         { return sym(PRINT); }
"printline"     { return sym(PRINTLINE); }
"read"          { return sym(READ); }
[A-Za-z]([A-Za-z0-9_]*) { return sym(IDENT,yytext()); }
([0-9]+)        { return sym(INTLIT,yytext()); }
'\\[nt\\']'     { return sym(CHARLIT,yytext()); }
'[^\\\n\t]'     { return sym(CHARLIT,yytext()); }
\" ([^\"\\\n\t] | "\\\\" | "\\\"" | "\\n" | "\\t")+ \" { return sym(STRINGLIT,yytext()); }
([0-9]+ "." [0-9]+) { return sym(FLOATLIT,yytext()); }
[\ \t\b\f\r\n]+ { /* eat whitespace */ }
"\\"[^\n]*      { /* one-line comment */ }
<<EOF>>         { return sym(EOF); }
.               { throw new Error("Unexpected character ["+yytext()+"]"); }
