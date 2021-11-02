import java_cup.runtime.Symbol;

%%

%cup
%implements sym

%{ 

  private Symbol sym(int sym) {
    return new Symbol(sym);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym, val);
  }
%}

alphanumeric    = {letter}|{digit}
bool 			= (true)|(false)
char            = '{str_char}'
comment         = ({slc_start}{comment_body})|({mlc_start}{mlc_body}{mlc_end})
comment_body    = {non_newline}*
digit           = [0-9]
float           = {int}\.{int}
ident 		    = {letter}{alphanumeric}*
int 			= {digit}*
letter          = [A-Za-z]
mlc_end 		= \*\\
mlc_start 		= \\\*
non_newline	    = [^\n]
mlc_body 		= ([^\*]|(\*[^\\]))*
slc_start       = \\\\
str 			= \"{str_char}*\"
str_char 		= [^\n\t\"'\\]|\\n|\\t|\\\\|\\\"|\\'
whitespace      = [\ \t\b\f\r\n]+

%%

if 				{ return sym(IF); }
else 			{ return sym(ELSE); }
fi 				{ return sym(FI); }
while 			{ return sym(WHILE); }
read 			{ return sym(READ); }
print 			{ return sym(PRINT); }
printline 		{ return sym(PRINTLN); }
return 			{ return sym(RETURN); }
int 			{ return sym(INT); }
char 			{ return sym(CHAR); }
bool 			{ return sym(BOOL); }
float 			{ return sym(FLOAT); }
final 			{ return sym(FINAL); }
class 			{ return sym(CLASS); }
void 			{ return sym(VOID); }
"="             { return sym(EQUALS); }
";"             { return sym(SEMI); }
","             { return sym(COMMA); }
"||"			{ return sym(VERTICAL_BARS); }
"&&"			{ return sym(AMPERSANDS); }
"=="			{ return sym(EQUAL_EQUAL); }
"<"				{ return sym(LESS_THAN); }
">"				{ return sym(GREATER_THAN); }
"<="			{ return sym(LESS_EQUAL); }
">="			{ return sym(GREATER_EQUAL); }
"<>"			{ return sym(LESS_GREATER); }
"--"            { return sym(DECREMENT); }
"++"            { return sym(INCREMENT); }
"-"             { return sym(MINUS); }
"+"             { return sym(PLUS); }
"?"             { return sym(QUESTION); }
":"             { return sym(COLON); }
"~"             { return sym(TILDE); }
"*"             { return sym(TIMES); }
"/"             { return sym(DIV); }
"("             { return sym(LPAR); }
")"             { return sym(RPAR); }
"{"             { return sym(LBRAC); }
"}"             { return sym(RBRAC); }
"["             { return sym(LSBRAC); }
"]"             { return sym(RSBRAC); }
{bool} 			{ return sym(BOOL_LIT,yytext()); }
{ident} 		{ return sym(IDENT,yytext()); }
{int} 			{ return sym(INT_LIT,yytext()); }
{char} 			{ return sym(CHAR_LIT,yytext()); }
{str} 			{ return sym(STR_LIT,yytext()); }		
{float} 		{ return sym(FLOAT_LIT,yytext()); }
{whitespace}	{ /* eat whitespace */ }
{comment}	    { /* comment */ }
<<EOF>>         { return sym(EOF); }
.               { throw new Error("Unexpected character ["+yytext()+"]"); }
