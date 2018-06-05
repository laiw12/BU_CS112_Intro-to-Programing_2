/*
 * File: Statistics.java
 * Author:Lai Wei
 * email: laiw12@bu.edu
 * Date: January 30th, 2015
 * Purpose: Lab problem 1
 */



import java.util.Scanner;
public class Statistics{
  public static void main(String[] args){
    System.out.println("\nWelcome to the Statistics Program!");
    System.out.println("This program will print out the sum and standard deviation");
    
    Scanner userInput = new Scanner(System.in);
    int count = 0;                                                                       // initialize variables
    double average =0.0;
    double sum =0.0;
    double square = 0.0;
    double input=0.0;
    double a =0.0;
    double b =0.0;
    double deviation =0.0;
    while(userInput.hasNextDouble()){                                                    //use while loop to process user input 
      System.out.println("\n Type in the number and hit return;");                   
      input = userInput.nextDouble(); 
      sum += input;
      square += (input*input);
      a -= 2*input;
      ++count;
    }
     average = sum/count;
     a = a * average;
     b = count *average*average;
      deviation = Math.sqrt((square+ a +b)/(count)); 
    System.out.println("The average is:"+average);                                         // print out results
    System.out.println("The deviation is:"+deviation);
  }
}

