/* File: BigIntegerCalculator.java
 * Date: 2/28/15
 * Author:  Lai Wei
 * Class: CS 112, Spring 2015
 * Purpose: This is the  code for HW 06, Problem B.4
 */

import java.io.*;
import java.util.*;

public class BigIntCalculator {
  private static void printMessage() {
    System.out.println("Big Int Calculator:"); 
    System.out.println("Enter an arithmetic expression with big integers, *, and +, with ");
    System.out.println("all expressions fully parenthesized, and spaces between all tokens; ");
    System.out.println("type Control-d to end."); 
  }
  
  public static void main(String[] args) {
    
    Stack <String>  Ops = new Stack<String>();
    Stack <BigInt> Nums = new Stack<BigInt>();
    
    System.out.println("This is the starter code for the Big Integer Calculator, ");
    System.out.println("all it does is give you the input control structure; it");
    System.out.println("simply reads each token and prints it out.");
    
    Scanner sc = new Scanner(System.in);
    
    while(sc.hasNext()) {
      
      String s = sc.nextLine();
      String[] exp = s.split("\\s+");
      for(int i =0; i <exp.length;++i){
        if(exp[i].equals("(")){                                                                  // follow the step described in the question
          // use s,equals to compare Strings
        }
        else if(exp[i].equals("*") || exp[i].equals("+")){
          Ops.push(exp[i]);
        }
        else if (exp[i].equals(")")){
          BigInt A = Nums.pop();  
          BigInt B = Nums.pop();
          String C = Ops.pop();
          if(C.equals("*")){
            Nums.push(A.mult(B));
          }
          if(C.equals("+")){
            Nums.push(A.add(B));
          }
        }
        else{
          BigInt m = new BigInt(exp[i]);                       // convert to BigInt
          Nums.push(m);
        }
      }
      System.out.println(Nums.pop()); 
    }
    System.out.println("Bye");
    
  }
}