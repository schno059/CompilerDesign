class C {
	int aggregator;
	int i;

	int sum(int a, int b){return a + b;}
	
	float avg(float a, float b, float c, float d, float e) {
		float temp = a + b + c + d + e;
		return temp/5;
	}
	
	char theFirstChar(char a, char b){return a;}
	
	void w_printIndex() {
		print("Printing value of i: ");
		print(i);
		i = +i;
	}
	
	void w_aggregateIndex() {
		aggregator = aggregator + i;
		i = +i;
	}
	
	bool tripleInvert(bool invertThing) {return ~(~(~invertThing));}
	
	int tripleIncrementAndMultiply(int a, int b) {
		a = +(+(+a));
		b = +(+(+b));
		return a*b;
	}
	
	bool inAscendingOrder(float a, float b, float c, float d, float e) {
		bool aLessThanB = a < b;
		bool bLessThanC = ~(b >= c);
		bool cGreaterEqualD = ~(~(c >= d));
		bool cLessThanD = ~cGreaterEqualD;
		bool dLessThanE = (d < e);
		
		print(" ");
		
		if (aLessThanB) print("A<B");
		else print("A>=B");
		fi
		
		if (bLessThanC) print("B<C");
		else print("B>=C");
		fi
		
		if (cLessThanD) print("C<D");
		else print("C>=D");
		fi
		
		if (dLessThanE) print("D<E");
		else print("D>=E");
		fi
		
		return aLessThanB && bLessThanC && cLessThanD && dLessThanE;
	}
	
	void doTheRest() {
		char a;
		char b;
		char c;
		char d;
		
		int i1;
		int i2;
		
		read(a,b,c,d);
		print("Letters");
		print(a,b,c,d);
		
		print(" ");
		print("Testing another while loop");
		i = 0;
		while(i<6) w_printIndex();
		
		print(" ");
		print("Aggregating i values 0 through 9");
		i = 0;
		while(i<10) w_aggregateIndex();
		print(aggregator);
		
		print(" ");
		print("Aggregating i values 0 through 99");
		i = 0;
		aggregator = 0;
		while(i<100) w_aggregateIndex();
		print(aggregator);
		
		print(" ");
		print("Average of aggregator with 5,6,7, and 8.5");
		print(avg(aggregator,5,6,7,8.5));
		
		print(" ");
		print("PEMDAS TEST 55*34+3/12+(43/4+1787)");
		print(55*34+3/12+(43/4+1787));
		print("PEMDAS TEST 765+3464*34");
		print(765+3464*34);
		print("PEMDAS TEST 765*3464+34");
		print(765*3464+34);
		
		print(" ");
		print("Printing the first char");
		print(a);
		print(theFirstChar(a, d));
		
		print(" ");
		print("Triple invert 'false'");
		print(false);
		print(tripleInvert(false));
		
		print(" ");
		print("Triple invert 'true'");
		print(true);
		print(tripleInvert(true));
		
		print(" ");
		print("Triple increment then multiply input values");
		read(i1,i2);
		print(i1,i2);
		print(tripleIncrementAndMultiply(i1,i2));
		
		print(" ");
		print("Again but with prior values subtracted by 10");
		print(i1-10,i2-10);
		print(tripleIncrementAndMultiply(i1-10,i2-10));
	}
	
	void main() {
		int a;
		int b;
		int c;
		int d;
		int e;
		
		read(a,b);
		print("Sum of a and b");
		print(sum(a,b));
		
		print(" ");
		read(a,b,c,d,e);
		print("Average of a, b, c, d, and e");
		print(avg(a,b,c,d,e));
		
		print(" ");
		print("Testing a while loop");
		i = 0;
		while(i<15) w_printIndex();
		
		print(" ");
		print("Numbers:");
		print(a,b,c,d,e);
		print(inAscendingOrder(a,b,c,d,e));
		
		print(" ");
		print("Numbers:");
		print(a,c,b,e,d);
		print(inAscendingOrder(a,c,b,e,d));
		
		read(a,b,c,d,e);
		
		print(" ");
		print("Numbers:");
		print(a,b,c,d,e);
		print(inAscendingOrder(a,b,c,d,e));
		
		print(" ");
		print("Numbers:");
		print(a,c,b,e,d);
		print(inAscendingOrder(a,c,b,e,d));
		
		print(" ");
		{
			int a = 86;
			print("Internal A");
			print(a);
		}
		
		print("External A");
		print(a);
		
		print(" ");
		doTheRest();
	}
};