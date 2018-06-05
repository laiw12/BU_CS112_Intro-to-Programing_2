/*
 * File: Age.java
 * Author:Lai Wei
 * Date: January 28th, 2015
 * Purpose: This is one part of the solution to HW01, problem B.1
 */

public class Age{
  public static void main(String [] args) {
    int ageInSeconds = 1234567890;
    double years = ((double)ageInSeconds)/((double)(3600*24*365));
    double months = ((double)ageInSeconds)/((double)(3600*30*24));
    double days = ((double)ageInSeconds)/(3600*24);
    int Months = (ageInSeconds - 365*39*24*3600)/(3600*30*24);
    int Days = (ageInSeconds - 365*39*24*3600- Months*24*3600*30)/(3600*24);
    int Hours= (ageInSeconds - 365*39*24*3600- Months*24*3600*30-Days *3600*24)/(3600);
    int Minutes =(ageInSeconds -365*39*24*3600- Months*24*3600*30- Days *3600*24-Hours*3600)/(60);
    int Seconds =(ageInSeconds -365*39*24*3600- Months*24*3600*30- Days *3600*24-Minutes*60-Hours*3600);
   
    System.out.println("The age in years:" + years);
    System.out.println("The age in months:" + months);
    System.out.println("The age in days:" + days);
    System.out.println("39 years " + Months +" months " + Days+" days "+ Hours+ " hours " +Minutes+" minutes "+Seconds+" seconds");
    
  }
}
      
      