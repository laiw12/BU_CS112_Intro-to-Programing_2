/* File: IMBD.java
 * Author: Lai Wei
 * Date: 4/7/15
 * Purpose: This is the answer for HW09, Problem B.3, CS 112, Spring 2015
 */

import java.io.*;
import java.util.*;

public class IMDB { 
  
  
  private static void readInFile(String fileName, Index I) {  
    
    final int maxLength = 5000;     // in fact our file will have 4110 lines
    
    try {
      
      Scanner sc = new Scanner(new File(fileName));
      
      // read data from text file into array of strings
      String[] M = new String[maxLength];
      
      int next; 
      for(next = 0; next < maxLength && sc.hasNextLine(); ++next)  {     
        M[next] = sc.nextLine();                 // read next line of file
      }
      
      //  split each line into token on the separator "; "
      // and insert the entry into the Index; the first token is the key
      // and the remaining tokens are the cast. 
      
       for(int i=0;i<next;++i){
        String lines[] = M[i].split(";");
        String [] lines1 = new String [lines.length-1];
        for(int j =1;j<lines.length;++j){
          lines1[j-1] = lines[j];
        }
        I.insert(lines[0],lines1);
      }
  
      
      
    }
    catch(FileNotFoundException e) {
      System.out.println(e.getMessage()); 
    }
  }
  
  // unit tests
  
  
  public static void main (String[] args) { 
    
Index I = new Index(); 
    readInFile("moviesTest.txt", I);
  
    System.out.println("\n[1] Printing out keys... should be:\n");
    System.out.println("\t\tSleepless in Seattle\n"
                         +"\t\t\t\tShining, The\n"
                         +"\t\t\tShape of Things, The\n"
                         +"\tMarked for Death\n"
                         +"\t\t\tJersey Girl\n"
                         +"\t\tCrocodile Dundee II\n"
                         +"\t\t\tConformista, Il\n"
                         +"Austin Powers in Goldmember\n"
                         +"\t\t101 Dalmatians\n"
                         +"\t100 Girls\n");
    I.printTreeKeys();
    
    System.out.println("\n[2] Testing size... should be:\n10");
    System.out.println(I.size()); 
    
    System.out.println("\n[3] Testing height... should be:\n4");
    System.out.println(I.height());
    
    System.out.println("\n[4] Testing getValues... should be:\nnull");
    
    System.out.println(I.getValues("Enter The Dragon"));
    
    System.out.println("\n[5] Testing getValues... should be:\n[Michael, Terence;McNet, Mike;Courtney, Dustin;Green, Donald;Ross, Bradley K.;Payne, Allen;Nagel, Seth;Madalone, Dennis;Davila, Edward;Green, Johnny;Szmanda, Eric;Bleiberg, Ehud;Bustard, Chris;Howard, Walker;Tucker, Jonathan;DeBello, James;OHara, John;Corpas, Londonn;Mars, Felicity;Steger, Julieanne]");
    System.out.println(); 
    System.out.println(I.getValues("100 Girls"));
    
    // Now build an inverted index
    System.out.println("\nBuilding inverted index....");
    Index InvI = I.getInvertedIndex();
    
    System.out.println("\n[6] Testing size... should be:\n435");
    System.out.println(InvI.size()); 
    
    System.out.println("\n[7] Testing height... should be:\n18");
    System.out.println(InvI.height());
    
    System.out.println("\n[8] Testing getValues... should be:\n[Austin Powers in Goldmember;Marked for Death]");
    
    System.out.println(InvI.getValues("DeVito, Danny"));
    
    I = new Index(); 
    readInFile("movies.txt", I);
    
    System.out.println("\n[9] Testing size... should be:\n4110");
    System.out.println(I.size()); 
    
    System.out.println("\n[10] Testing height... should be:\n30");
    System.out.println(I.height());
    
    System.out.println("\n[11] Testing getValues... should be:\n[Vernon, Richard;Cranwell, Peter;Sakata, Harold;McLaren, John;Simmons, Bob;Joint, Alf;Young, Raymond;Thomas, Varley;Cowles, Denis;Linder, Cec;Llewelyn, Desmond;Brook, Terence;Connery, Sean;Wilson, Michael G.;MacLeod, Robert;Chinn, Anthony;Lee, Bernard;Rabin, Lenny;Brace, Peter;Nagy, Bill;Kwouk, Burt;Galili, Hal;Willis, Austin;Mellinger, Michael;Frobe, Gert;Duggan, Gerry;Leech, George;Brooks, Victor;Benson, Martin;Tremayne, Les;Collins, Michael;Blackman, Honor;Regin, Nadja;Gardner, Caron;Rowsell, Janette;Mallet, Tania;Wright, Maggie;Morrison, Aleta;Collins, Marian;Maxwell, Lois;Ling, Mai;Muller, Tricia;Eaton, Shirley;Hill, Lesley;Nolan, Margaret]");
    System.out.println(); 
    System.out.println(I.getValues("Goldfinger"));
    
    // Now build an inverted index
    
    System.out.println("\nBuilding inverted index....");
    InvI = I.getInvertedIndex();
    
    System.out.println("\n[12] Testing size... should be:\n112203");
    System.out.println(InvI.size()); 
    
    System.out.println("\n[13] Testing height... should be:\n41");
    System.out.println(InvI.height());
    
    System.out.println("\n[14] Testing getValues... should be:\n[Austin Powers in Goldmember;Anything Else;Bananas;Batman Returns;Be Cool;Big Fish;Big Kahuna, The;Death to Smoochy;Duplex;Drowning Mona;Get Shorty;Heist;Hercules;Hoffa;Jewel of the Nile, The;Johnny Dangerously;Junior;L.A. Confidential;Last Action Hero;Look Whos Talking Now;Living Out Loud;Man on the Moon;Mars Attacks!;Matilda;Other Peoples Money;One Flew Over the Cuckoos Nest;Rainmaker, The;Renaissance Man;Romancing the Stone;Ruthless People;Screwed;Space Jam;Terms of Endearment;Throw Momma from the Train;Tin Men;Twins;Virgin Suicides, The;War of the Roses, The;Whats the Worst That Could Happen?]");
    System.out.println(); 
    System.out.println(InvI.getValues("DeVito, Danny"));
      
  }

   
}

