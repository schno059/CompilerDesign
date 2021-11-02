JAVA=java
JAVAC=javac
# Root of the project
JFLEX=./jflex
CUPJAR=java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: test

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $*.java


FILE=	Yylex.java      parser.java    sym.java \
        Main.java AST.java ASTClass.java ASTListOfDecls.java \
        ASTDecl.java ASTDeclVar.java ASTDeclMethod.java \
        ASTDeclArray.java ASTDeclArg.java \
        ASTExpr.java ASTExprLitBool.java ASTExprLitChar.java \
        ASTExprLitFloat.java ASTExprLitInt.java ASTExprLitString.java \
        ASTExprUnary.java ASTExprBinary.java ASTExprTrinary.java \
        ASTExprVarRef.java ASTExprArrayRef.java \
        ASTExprClassArrayRef.java ASTExprClassFieldRef.java \
        ASTExprCast.java ASTExprMethodCall.java \
        ASTStmt.java ASTStmtCodeBlock.java ASTStmtAssign.java ASTStmtIf.java \
        ASTStmtMethodCall.java ASTStmtPrint.java ASTStmtRead.java \
        ASTStmtReturn.java ASTStmtUpdate.java ASTStmtWhile.java \
        SymbolTable.java NameTable.java \
        STEntry.java STClassEntry.java STVarDeclEntry.java \
        Type.java TypeBase.java TypeClass.java TypeError.java

run: output.txt

output.txt: all
	$(JAVA) -cp $(CP) Main < example.as > output.txt
	cat output.txt

all: Yylex.java parser.java $(FILE:java=class)

clean:
	rm -f *.class *~ *.bak Yylex.java parser.java sym.java

Yylex.java: scanner.jflex
	$(JFLEX) scanner.jflex

parser.java: parser.cup
	$(CUP) -interface -dump < parser.cup

test: output.txt
	@(diff output.txt output.good && echo "Test OK!") || echo "Test failed!"
