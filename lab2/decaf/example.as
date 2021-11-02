
\\This is the example class for testing stuff

class example {
	final int finInt = 5;
	final char finChar = 'A';
	final bool finBool = true;
	final float finFloat = -23987.123;
	
	int myGlobalInt;
	char myGlobalChar;
	bool myGlobalBool;
	float myGlobalFloat;
	
	int myGlobalIntArray[];
	char myGlobalCharArray[];
	bool myGlobalBoolArray[];
	float myGlobalFloatArray[];
	
	int intMethodOne(int par1, int par2, int par3)
	{
		final int finLocalInt = -2786;
		final char finLocalChar = '\n';
		final bool finLocalBool = false;
		final float finLocalFloat = 99999.98776666;
		
		int myLocalInt = -35434;
		char myLocalChar = 'j';
		bool myLocalBool;
		float myLocalFloat;
		
		int myLocalIntArray[5];
		char myLocalCharArray[4];
		bool myLocalBoolArray[3456];
		float myLocalFloatArray[45];
		
		bool expr1 = true;
		\\testing precedence and also some wacky spacing
		int expr2 = (2 + 3) +
										5
										
											*
											
													8
													
													
														-
														
															6
																
																	/ 
																	
																			86;
		\\let's see that precedence in action
		bool expr3 = 5 == 7 && 6 == 9 || 45 <=23 && 2434 > 2 <> 3;
		bool expr4 = false||true&&2<>4<=5+3*8-6>9>=10;
		bool expr5 = 1||2&&3==4<>5<=6>=7<8>9+10-11*12/13;
		bool expr6 = 1/2*3-4+5>6<7>=8<=9<>10==11&&12||13;
		
		if(expr1 == expr2) a = b;
		else b = a;
		fi
		
		if(expr2 == expr3) b =          c;
		else
		
		
		
		
		
		
		
		c=b;
														fi
														
														
		while(expr1 == expr2) a++;
		if(expr1==expr2)if(expr3==expr4)a++;else b++; fi else c++; fi
		while(expr1==expr2&&expr3==expr4) if(expr5==expr6)
			a++;
			b++;
			c++;
			d++;
		fi
		return 1;
	}
	float myMethodTwo(float par1, char parArray[]) {
		return 5.0;
	}
	\\testing some methods
	char myMethodThree(int par1, char par2, float par3)
	{
			
				
						return par2;
	};
		char myMethodThree(int par1, char par2, float par3)
	{
	};
	\*
	Multi
	Line
	Comment
	*\
	bool mymethodFour(int arr1[], int arr2[], int arr3[])
	{
	
	
		
		
			
				return false;
	};
	void main()
	{
		int a = anExpression;
		float b = +expression;
		read(readlist);
		read(readlist1, readlist2, readlist3, readlist4);
		print(expr1);
		print(expr3, expr4, expr5, expr6);
		printline();
		name = expr1;
		return anExpression;
		return (expr1 ? expr2 : expr3);
		return a + b * c;
		return (int) expression;
		return (float) anExpression;
		return (char) anExpression;
		return (bool) anExpression;
		return +expression;
		return -expression;
		return ~expression;
		return (((((parenthesisExpression)))));
		
		return 1;
		return 2;
		return 3;
		return 4;
		return -5;
		return 99;
		
		return 'a';
		return 'b';
		return 'c';
		return '\t';
		
		return "apple";
		return "banana";
		return "the whole damn alphabet";
		
		return true;
		return false;
		
		return 3.141592653589793238462643383279502884197169399375105;
		return 1.0;
		return -99.0;
		
		myMethod();
		myMethod(expr1+expr2, ~+expr3);
		myMethod(expr1+expr2, ~+(-(-(expr3))));
		return myMethod(21);
		return myOtherMethod(par1, par2, par3);
		{ int i = 5; a++;};
		{ float r = 5.0; char c = 'c'; a++;}
	}
};