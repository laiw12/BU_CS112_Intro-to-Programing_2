/* File: Lab03.java
 * Author: Lai Wei
 * Date: 2/5/2015
 * Purpose:This is my homework 3 problem B1
 */

import java.util.Scanner;

public class Lab03 {
  
  public static void main(String [] args) {
    
  IntStack S = new IntStack();                                                                    // Create an instance for my IntStack.
    
    System.out.println("Welcome to the Integer Addition Program; you may input");
    System.out.println("integers to be stored on a stack, remove them, or add");
    System.out.println("the top two integers and push it back on the stack.");
    
    System.out.println("\nWhat would you like to do?");
    System.out.println("   1 -- Input an integer and push it on the stack;");    
    System.out.println("   2 -- Pop an integer off the stack and print it;");     
    System.out.println("   3 -- Add the top two integers and push the result back on the stack;");
    System.out.println("   4 -- Multiply the top two intergers and push the result back on the stack;");
    System.out.println("   5 -- Subtract  the top two integers and push the result back on the stack;");
    System.out.println("   6 -- Print out the stack;");
    System.out.println("Please input 1, 2, 3, 4, 5 , 6 or hit Control-d to end the program.");
    
    int answer = 0; 
    int n = 0; 
    int m = 0; 
     
    Scanner input = new Scanner(System.in); 
    while(input.hasNextInt()) {   
    
     
      answer = input.nextInt(); 
        if (( answer ==3 || answer==4 || answer==5)  && S.size() <2){
        System.out.println("You have to input at least 2 intergers. The programme will be terminated.");
        break;
      }
        if(answer==2&& S.size()<1){
       System.out.println("If you to pop an integer off,there must be at least one number on the stack");
       break;
        }
      
      if(answer == 1) {                                                                                                        // use my IntStack class to do operations.
        System.out.println("What integer would you like to push on the stack?");
        n = input.nextInt(); 
       S.push(n);
      }
      else if(answer == 2) {
         n= S.pop();
        System.out.println("\nThe number " + n + " has been popped off the stack."); 
      }
      else if(answer == 3) {
       n = S.pop();
       m = S.pop();
       S.push(m+n);
      }
      else if(answer ==4){
       n = S.pop();
       m = S.pop();
       S.push(m*n);
      }
      else if(answer ==5){
      n = S.pop();
       m = S.pop();
       S.push(n-m);
      }
      else if(answer ==6){
        if(S.isEmpty()){
          System.out.println("The stack is empty.");
        }
        else{
         String stack = S.toString();
         System.out.println(stack);
        }
      }
     
        
      else {
        System.out.println("Illegal input, try again!");
      }
      
      System.out.println("\nWhat would you like to do?");
      System.out.println("   1 -- Input an integer and push it on the stack;");    
      System.out.println("   2 -- Pop an integer off the stack and print it;");     
      System.out.println("   3 -- Add the top two integers and push the result back on the stack;");
      System.out.println("   4 -- Mutiply the top two intergers and push the result back on the stack;");
      System.out.println("   5 -- Substract  the top two integers and push the result back on the stack;");
      System.out.println("   6 -- Print out the stack;");
      System.out.println("Please input 1, 2, 3, 4, 5, 6 or hit Control-d to end the program.");
    }
    
  } 
}
 
