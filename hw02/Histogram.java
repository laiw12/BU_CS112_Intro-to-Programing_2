/*
 * File: Histogram.java
 * Author:Lai Wei
 * emmail: laiw12@bu.edu
 * Date: January 30rd, 2015
 * Purpose: hw2 problem B.2
 */




import java.util.Scanner;
public class Histogram{
  public static void main(String[] args){
    System.out.println(" Welcome to the Histogram Program!");
    System.out.println(" This program will print out a histogram of the numbers");
    System.out.println("in put by the user; enter up to 20 doubles and hit Control-d to end.");
    Scanner userInput = new Scanner(System.in);
    double input =0.0;
    double[] number = new double[20];
    int[] histogram = new int[10];
    int i;
  
    
     for (  i =0; userInput.hasNextDouble(); ++i){
       if (i >=20){
          System.out.println("Maximum number of input(20) exceeded, proceeding to calculate Histogram...");2
         break;
       }
         
       
      input = userInput.nextDouble(); 
      while((input < 0)||(input>100)){
        System.out.println("Input must be a double in range [0..100], try again!");   //error checking
        input = userInput.nextDouble();}
      number[i] = input;
    }
     
    for (int s =0; s<i;++s){                                                         // caculating the value of which group to falls in .
      for (int f = 0; f<=10 ;++f){
        if((number[s] <= f*10) &&((f*10-number[s])<10)){
          ++histogram[f-1];
        }
      }
    }
      System.out.print("You input " + i+" numbers:[");                               // print out the histogram 
    for(int h=0;h<i-1;++h){
      System.out.print(number[h]+", ");}
    System.out.print(number[i-1]+"]\n");
    System.out.println("Histogram of values in Decades from 0 to 100:");
    
    for(int j=0;j<10;j=j+1){
      if (j==0){
        System.out.print("[0..10]:\t" );
        for (int a = histogram[j];a>0;--a){
          System.out.print("*");}
        System.out.print("\n");
        
      }
      else{
        System.out.print("("+j*10+".."+(j*10+10)+"]:\t");
        for (int a = histogram[j];a>0;--a){
          System.out.print("*");}
        System.out.print("\n");
      }
    }
  }
}                      







          
       
       
    
    

    
    