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
	AST.java 	ExprAST.java	StmtAST.java    \
	StmtsAST.java	AssignStmtAST.java	\
	IdentAST.java	IntAST.java	\
	BinaryExprAST.java	\
	Main.java 

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
	$(CUP) -interface < parser.cup

test: output.txt
	@(diff output.txt output.good && echo "Test OK!") || echo "Test failed!"
