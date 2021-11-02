
\*
	Test Class
	Author: Jacob Schnoor
	Date: 4/3/21
*\

class myClass {
	int myInt;
	float myFloat;
	char myChar;
	bool myBool;
	
	int myOtherInt = 5;
	float myOtherFloat = 7.5;
	char myOtherChar = 'a';
	bool myOtherBool = false;
	
	final int myFinalInt;
	final float myFinalFloat;
	final char myFinalChar;
	final bool myFinalBool;
	
	final int myOtherFinalInt = 576;
	final float myOtherFinalFloat = 32;
	final char myOtherFinalChar = myFinalChar;
	final bool myOtherFinalBool = 9999999;
	
	int myIntArr[];
	float myFloatArr[];
	char myCharArr[];
	bool myBoolArr[];
	
	int myOtherIntArr[545];
	float myOtherFloatArr[334];
	char myOtherCharArr[2345];
	bool myOtherArr[23];
	
	int myIntFunc(){return 7;};
	float myFloatFunc(){return 3.0;};
	char myCharFunc(){return 'a';};
	bool myBoolFunc(){return true;};
	
	int myOtherIntFunc(){return myOtherInt;};
	float myOtherFloatFunc(){return myInt;};
	char myOtherCharFunc(){return myFinalChar;};
	bool myOtherBoolFunc(){return myFinalInt;};
	
	int myParamFunction(float param1, bool param2, int param3, char param4)
	{
		print(param1);
		return +myInt;
	};
	
	char myOtherParamFunction(char a, char b, char c)
	{
		print(a);
		print(b);
		print(c);
		return b;
	};
	
	float qcInserter(float qc)
	{
		return qc;
	}
	
	void paramTester()
	{
		int myInt = myParamFunction(5,5,5,'h');
		myInt = myParamFunction(345345.12213,true,2,'h');
		myInt = myParamFunction(4.12,false,98,'h');
		paramTester();
		myParamFunction(4,myBool,98,myFinalChar);
	};
	
	void noReturn()
	{
		char a[4];
		
		int myLocalInt = myFinalInt;
		
		float myOtherChar = myInt;
		bool myFinalFloat = true;
		{
			int myOtherChar = 564;
			while((myOtherChar==3)&&myFinalFloat||~(5>6<6)) print(a[2]);
			if(myOtherChar) myLocalInt++;
			else read(a[3]);
			fi
		}
		myInt = 5;
		myInt++;
		myInt--;
		{
			myFloat = myOtherChar / myIntFunc;
			myFloat = myInt / myInt;
			myFloat = myInt + myInt - myInt * myInt / myInt + (+(myInt));
		}
		print(+(-(~(myInt==myOtherInt))));
	};
	
	void returnNothing()
	{
		char myChar;
		read(myIntArr[3], myOtherFloatArr[3], myInt, myOtherInt, myOtherFinalBool);
		print(myOtherIntFunc);
		print((true ? 'a' : 'b'));
		print((7 ? 7 : 7) + 3.5, "heyyyyy");
		{
			{
				{
					int myDeeeeepInt = 7;
				}
			}
		}
		return;
	};

	void main()
	{
		char myOtherInt = 'c';
		myOtherChar = myOtherInt;
		print("Hello world");
		read(myBool);
		qcInserter(((+(7 ? 7 : 7))));
		if(3) myInt++;
		else read(myBoolArr[2]);
		fi
		
		if(myParamFunction(345345.12213,true,2,'h')) myFloat--;
		fi
		
		while(myParamFunction(37643856,myBoolArr[4],2,'h')) read(myFinalChar);
	};
};
