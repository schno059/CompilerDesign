class C {
  int i0;
  char c0;
  bool b0;
  float f0;
  string s0;
  int i1 = 1;
  int i2 = "hello";
  bool b1 = true;
  bool b2 = 'a';
  bool b3 = 1;
  char c1 = 'x';
  char c2 = 5.0;
  float f1 = 42.0;
  float f2 = true;
  float f3 = 5;
  string s1 = "hello";
  string s2 = 42;
  int i4 = i1 + 5;
  int i5 = i1 + 'c';
  float f4 = f1 + 4.0;
  float f5 = f1 + true;
  float f6 = f1 + i1;
  string s3 = s1 + "bye";
  int i6 = i4 - i1;
  float f7 = f6 - f4;
  float f8 = f4 - i1;
  int i7 = i4 - 'a';
  int i8 = i4 * 'a';
  int i9 = i4 / 'a';
  float f9 = i4 * i1;
  float f10 = f7 / i4;
  int undecl = i88 + i66;
  int multi;
  float multi;
  bool b4i = i1 < i4;
  bool b5i = i1 > i4;
  bool b6i = i1 <= i4;
  bool b7i = i1 >= i4;
  bool b8i = i1 == i4;
  bool b9i = i1 <> i4;
  bool b4f = f1 < f4;
  bool b5f = f1 > f4;
  bool b6f = f1 <= f4;
  bool b7f = f1 >= f4;
  bool b8f = f1 == f4;
  bool b9f = f1 <> f4;
  bool b4if = i1 < f4;
  bool b5if = i1 > f4;
  bool b6if = i1 <= f4;
  bool b7if = i1 >= f4;
  bool b8if = i1 == f4;
  bool b9if = i1 <> f4;
  bool b10 = i1 < s1;
  bool b11 = s1 > f4;
  bool b12 = 'a' <= c1;
  bool b13 = 'a' == c1;
  bool b14 = true == c1;
  bool b15 = 'a' <> c1;
  bool b16 = 'a' <> "hello";
  bool b17 = 'a' >= c1;
  bool b18 = ~ b0;
  bool b19 = b0 && b1;
  bool b20 = b0 || b1;
  bool b18i = ~ i0;
  bool b19i = i0 && i1;
  bool b20i = i0 || i1;
  bool b19if = i0 && f1;
  bool b20if = i0 || f1;
  bool b21 = ~s0;
  bool b22 = c0 && b0;
  bool b23 = f0 || b0;
  int iA[5];
  float fA[10];
  int i24 = (iA[1] + iA[i0]);
  float f25 = (fA[1] + fA[iA[2]]);
  int i26 = iA[2.0];
  int i27 = iA["string"];

  int f0() {
    i0 = 1;
    i0 = iA[3] + 5;
    f0();
  }

  void f1(int a, float b) {
    f0();
    f0(2);
    i0 = f1(2,3.0);
    f1("hello",'a');
  }

  int f2(int a, bool b, float c) {
    bool bA[20];
    f1(1);
    f1(3,3);
    f2(1,true,5.0);
    i0 = f2(i0 + 5,i0,3.0) * i0;
    iA[2] = 5;
    fA[3] = 21.0;
    fA[3] = 5;
    bA[4] = true;
    bA[5] = 0;
    iA = 5;
    iA[true] = 1;
    iA[3] = "string";
    i0[1] = 2;
  }

  void f3(int a, bool b, float b) {
    int a;
    float c;
    if (a == 5) {
      print(a,c);
    }
    else {
      int c;
      float a;
      i0 = a;
    }
    fi
    read(a,b,c*2);
    printline();
    return 5;
    return;
    a = 0;
    c = 3;
    while (a < 5) {
      c = (a + 1) * c;
      a++;
      c--;
    }
    while ("string") printline();
    if ('a') printline(); fi
  }
};
