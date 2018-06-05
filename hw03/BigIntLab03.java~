/* File:BigIntLab03.java
 * Date: 2/15/14
 * Author:  Lai Wei
 * Class: CS 112, Spring 2015
 * Purpose: This is my homework 3 problem B3.
 */



import java.util.Scanner;

public class BigIntLab03 {
  
  public static void main(String [] args) {
    
  BigIntStack S = new BigIntStack();                                     // Create an instance for my IntStack.
  
    
    System.out.println("Welcome to the BigInts Addition Program; you may input");
    System.out.println("BigInts to be stored on a stack, remove them, or add");
    System.out.println("the top two BigInts and push it back on the stack.");
    
    System.out.println("\nWhat would you like to do?");
    System.out.println("   1 -- Input an BigInt and push it on the stack;");    
    System.out.println("   2 -- Pop an BigInt off the stack and print it;");     
    System.out.println("   3 -- Add the top two BigInts and push the result back on the stack;");
    System.out.println("Please input 1, 2, 3 or hit Control-d to end the program.");
    
    String answer = "0"; 
    String n =""; 
  
     
    Scanner input = new Scanner(System.in); 
    while(input.hasNextLine()) {   
    
     
      answer = input.nextLine();  
      while(!BigInt.legalBigInt(answer)) {                                                         //check if the input is illegal
       System.out.println("Illegal input, try again!");
       answer = input.nextLine(); 
   }
 
 
                                                                                                    // read in input Strings as BigInts
      BigInt answer1 = new BigInt(answer);
        int[] one = {1};
        int[] two = {2};
        int[] three = {3};
        BigInt ONE = new BigInt(one); 
        BigInt TWO = new BigInt(two);
        BigInt THREE = new BigInt(three);
        
        if (( answer1.compareTo(THREE) ==0)  && S.size() <2){
        System.out.println("You have to input at least 2 BigInts. The programme will be terminated.");
        break;
      }
        if(answer1.compareTo(TWO) ==0 && S.size()<1){
       System.out.println("If you to pop an BigInt off,there must be at least one number on the stack. Programme will be terminated");
       break;
        }
      
      if(answer1.compareTo(ONE)==0) {                                                                                  // use my BigIntStack class to do operations.
        System.out.println("What BigInt would you like to push on the stack?");
        n = input.nextLine();
        if (BigInt.legalBigInt(n) == false){
          System.out.println(" Input must be legal, Programme will be terminated");
          break;
        }
        BigInt x = new BigInt(n);
         S.push(x);
      }
    
      else if(answer1.compareTo(TWO)==0) {
         BigInt x = S.pop();
        System.out.println("\nThe BigInts " + x.toString() + " has been popped off the stack."); 
      }
      else if(answer1.compareTo(THREE)==0) {
       BigInt x = S.pop();
       BigInt y = S.pop();
       S.push(x.add(y));
      }
     
        
      else {
        System.out.println("Illegal input, try again!");
      }
      
    System.out.println("\nWhat would you like to do?");
    System.out.println("   1 -- Input an BigInt and push it on the stack;");    
    System.out.println("   2 -- Pop an BigInt off the stack and print it;");     
    System.out.println("   3 -- Add the top two BigInts and push the result back on the stack;");
    System.out.println("Please input 1, 2, 3 or hit Control-d to end the program.");
  
    }
    
  } 
}
 
