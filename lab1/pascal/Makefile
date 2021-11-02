# uses JFlex >= 1.3.2, and CUP >= 0.10j
#
# targets:
#
# make all                                                            
#    generates lexer, and parser, and compiles all *.java files
#                                                                     
# make run (or just: make)                                           
#    starts the program on a test example
#                                                                     

JAVA=java
JAVAC=javac
# Root of the project
JFLEX=jflex
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $*.java

FILE=	PascalLexer.java      parser.java    sym.java \
	PascalLexerTest.java

run: test2-output.txt lexer-test-p-output.txt

test2-output.txt: all
	$(JAVA) -cp $(CP) PascalLexerTest test2.txt > test2-output.txt
	cat test2-output.txt

lexer-test-p-output.txt: all
	$(JAVA) -cp $(CP) PascalLexerTest lexer-test-p.txt > lexer-test-p-output.txt
	cat lexer-test-p-output.txt

all: PascalLexer.java parser.java $(FILE:java=class)

clean:
	rm -f *.class *~ *.bak PascalLexer.java parser.java sym.java

PascalLexer.java: pascal.jflex
	$(JFLEX) pascal.jflex

parser.java: pascal-tokens.cup
	$(CUP) -interface < pascal-tokens.cup
