/* File: MyStringArray.java
 * Author: Lai Wei
 * Date: January 30th, 2015
 * email: laiw12@bu.edu
 * purpose: hw02 Problem B.3
 */

public class MyStringArray { 
  
  // Declare various final (i.e., constant) values to be used to indicate errors of various types
  
  private static final char[] errorString = { 'N', 'a', 'S' };   // These next three are our choices for error outputs
  private static final char errorCharacter = '#';
  private static final int errorInteger = Integer.MIN_VALUE;
  private static final double errorDouble = Double.NaN;          // Nan results when dividing by 0, etc.
    
    // It error checks if i is in the right and then return the character indexed by i.
    private static char charAt(char[] s, int i) {
      if( i >=  s.length || i< 0){
        return errorCharacter;}
      else {
          return s[i];
      }
       }
  
 // Simply returns the length of the char s.
  private static int length(char[] s) {
    
    return s.length ;                
  }
  
  //  This returns the subsequence of char from location left to (right-1) as a new array of chars.
  private static char[] subString(char[] s, int l, int r) {
    int b =0;
    if( l>s.length || l<0 || r>s.length|| l<0|| l>r){                                       // error checking
      return errorString;
    }
    else{
     char[] number = new char[r-l];
       for(int a =l; a<r;++a){
       number[b] = s[a];
       ++b;}
       return number;
     }
      }
  
  //this returns a new array of chars in which any upper-case letters ('A' - 'Z') are replaced by their lower-case counterparts.
  private static char[] toLowerCase(char[] c) {
    char[] number = new char[c.length];
    for(int a=0; a < c.length;++a){
      if (c[a] >= 'A' && c[a] <= 'Z'){
        number[a] = (char)((c[a]+32)) ;}
      else {
        number[a]=c[a];}
      
    }
     return number ;             
  }
  
  // This returns a new array consisting of the chars in a followed by the chars in b; no error checking is done.
  private static char[] concatenate(char[] a, char[] b) {
    char[] number = new char[a.length + b.length];
    for(int i=0; i < a.length + b.length;++i){
      if(i < a.length){
        number[i] = a[i];}
      else{
        number[i] = b[i-a.length];
      }
    }
    return number;}
             
 
  
  //.This returns the integer value corresponding to the array of chars;if any non-digit occurs in the array, the error value  errorInteger  is returned; 
  private static int intValueOf(char[] a) {
     int x =0 ;
     if(a[0]=='+'){
       for (int j=0;j<a.length-1;++j){
         
       x  += Math.pow(10,a.length - j-2)*((int)a[j+1]-'0');
      
       }
    return x;   }
     
      if(a[0]=='-'){
       for (int j=0;j<a.length-1;++j){
       x  += Math.pow(10,a.length - j-2)*((int)a[j+1]-'0');
       }
     return -x; 
      }
      for(int i=0; i < a.length;++i){                                                    // error checking
       if (a[i] >= 'a' && a[i] <= 'z'){
         return errorInteger;
       }
       else if(a[i]=='.'){
         return errorInteger;
       }
       else{
         
         x += Math.pow(10,a.length - i-1)*((int)a[i]-'0');   
       }
     }
        return x;
  }
  
  // Similar to the previous, but the array is assumed to represent a double, with at most one decimal point '.'
  private static double doubleValueOf(char[] a) {
    int count=0;
    double x=0;
    int m=0;
    double y=0;
    for (int j=0;j<a.length;++j){                                                             //error checking
      if (a[j] >= 'a' && a[j] <= 'z'){
        return errorDouble;}
    }
      
    for (int j=0;j<a.length;++j){
      if(a[j]=='.'){
     ++count;
      }
    }
    if (count>=2){
      return errorDouble;
    }
    if (count ==0){
      for(int i=0; i < a.length;++i){
        x += Math.pow(10,a.length - i-1)*((int)a[i]-'0'); }                                    // using mathatic method to solve the problem
      return x;
    }
    if(a[0]=='.' && a.length==1){
      return 0.0;
     }
    if (a[0]=='.'){
      for (int i=0;i<a.length-1;++i){
        x  += Math.pow(0.1,a.length - i-1)*((int)a[i+1]-'0');
         }
      return x;}
    
     while(a[m]!='.'){
    ++m;
  }
  if (a[0]=='-'){
    for(int b=0; b<m-1;++b){
      x += Math.pow(10,m - b-2)*((int)a[b+1]-'0');}
    for(int n =m+1;n<a.length;++n){
      y  += Math.pow(0.1,n-2)*((int)a[n]-'0');}
    return -(x+y);
  }
  for(int j=0;j<m;++j){
    x += Math.pow(10,m - j-1)*((int)a[j]-'0')
     ; }

  for(int s=m+1;s<a.length;++s){
    y  += Math.pow(0.1,s-1)*((int)a[s]-'0');
     
  }
 
  return x+y;
   
}
  
  // Convert an int into a character array representing it; n may be negative, in which case the first character in the array should be '-'. 
  private static char[] int2MyString(int n) {
  if(n<0){
    n=-n;
       char[] x = new char[(int)(Math.log10(n)+2)];                // math.log10(n) can be used to determine the number of numbers in the number.
       x[0] ='-';
       
       for(int i = x.length-1; i>0;--i){
      x[i] = (char)((n%10)+'0');
                   
  
      n = n/10;}
       return x;}
    else{
    
   char[] x = new char[(int)(Math.log10(n)+1)];
    for(int i = x.length-1; i>=0;--i){
    x[i] = (char)((n%10)+'0');
  
    n = n/10;}
    return x;}
  }

    
    

 
  
  // This method provided for debugging
  private static void printCharArray(char[] A) {
    for(int i = 0; i < A.length; ++i) {
      System.out.print(A[i]);
    }
    System.out.println(); 
  }
  
  
   public static void main(String[] args) {
      
      System.out.println("\nGrading program for MyStringArray library\n");
      int testNum = 0; 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n8"); 
      char[] test = "CS112 A1".toCharArray(); 
      System.out.println(length(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\nC"); 
      System.out.println(charAt(test,0)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n1"); 
      System.out.println(charAt(test,7)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\n#"); 
      System.out.println(charAt(test,9)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112"); 
      System.out.println(subString(test,0,5)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n12 A1"); 
      System.out.println(subString(test,3,8)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
      System.out.println(subString(test,-1,4)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
      System.out.println(subString(test,1,9)); 
      System.out.println();  
                        
      System.out.println("Test " + (++testNum) + ": Should be:\ncs112 a1"); 
      System.out.println(toLowerCase(test)); 
      System.out.println();
                              
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1"); 
      System.out.println(test); 
      System.out.println();
                        
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1CS112 A1"); 
      System.out.println(concatenate(test,test)); 
      System.out.println();
     
      System.out.println("Test " + (++testNum) + ": Should be:\n234"); 
      test = "234".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
    
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-234"); 
      test = "-234".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
      test = "234.4".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
      test = "23a4".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\n3.141592"); 
      test = "3.141592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();   
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-3.141592"); 
      test = "-3.141592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n10.0"); 
      test = "10.".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n0.5"); 
      test = ".5".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
            
      System.out.println("Test " + (++testNum) + ": Should be:\n0.0"); 
      test = ".".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\n234.0"); 
      test = "234".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
      test = "3.141.592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
      test = "3.141a592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      int n = 12345; 
      System.out.println("Test " + (++testNum) + ": Should be:\n12345"); 
      printCharArray( int2MyString(n) ); 
      System.out.println(); 
      
      n = -45; 
      System.out.println("Test " + (++testNum) + ": Should be:\n-45"); 
      printCharArray( int2MyString(n) ); 
      System.out.println(); 
      
      

   }
  
}