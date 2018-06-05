/*
 * File: Statistics.java
 * Author:Lai Wei
 * Date: January 28th, 2015
 * Purpose: This is one part of the solution to HW01, problem B.2
 */


  import java.util.Scanner;
public class Statistics{
  public static void main(String [] args) {
    System.out.println("\nWelcome to the Statistics Program!");
    System.out.println("This program will print out the sum, max, mean, variance, and");
    System.out.println("standard deviation for three integers input by the user.");
     Scanner userInput = new Scanner(System.in);
     System.out.println("\nType in the first number and then hit return:"); 
    int numOne = userInput.nextInt(); 
    
    System.out.println("\nType in the second number and then hit return:"); 
    int numTwo = userInput.nextInt(); 
    
    System.out.println("\nType in the third number and then hit  return:"); 
    int numThree = userInput.nextInt(); 
   
    System.out.println("\nYou have input the numbers " + numOne + ", " + numTwo + ", and " + numThree);
    int x = numOne + numTwo + numThree;
    System.out.println("The sum is:" + x);
    double y = Math.max(numOne, numTwo);
    double z = Math.max(y, numThree);
    System.out.println("The max is:" + z);
    double w = (double)x/3;
    System.out.println("The average is:" + w);
    double a = ((numOne-w)*(numOne-w) + (numTwo-w)*(numTwo-w) + (numThree-w)*(numThree-w))/3;
    System.out.println("The variance is:" + a);
    double b = Math.sqrt(a);
    System.out.println("The standard deviation is:" + b);
    
    
    
    
  }
}
    