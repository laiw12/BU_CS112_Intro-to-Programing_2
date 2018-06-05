/* Program: IntCollection.java
 * Author: Lai Wei
 * Date: 2/17/2015
 * Class: CS 112
 * Purpose: This is part of my homework 4 Problem B.1  
 * 
 */
import java.util.Arrays;

public class IntCollectionLab {   
   private boolean debug = true;           // set this to true if you want to trace your execution
    private void db(String s) {            
          if(debug) 
             System.out.println("\t" + s);
      }
 
   
   private final int DEFAULT_SIZE = 20; 
   
   private int [] A; 
   private int next; 
   
   // Constructor, default is to give size of 20
   
   public IntCollectionLab() {
      A = new int[DEFAULT_SIZE];
      next = 0; 
   }
   
   // Constructor which allows you to specify size of array
   
   public IntCollectionLab(int size) {
       A = new int[size];
      next = 0;      
   }
   
   
   // To insert, first check if it is already there (no duplicates allowed!)
   // Scan from the right and move every element which is > over one slot to R; then insert
   // the new int when you find something <=.
   // Special case occurs if run off end of array without finding <= element.
   
   public void insert(int k) { 
     db(toString());
     db("insert( " + k + " )");
      
      // Here's where to trace what number you are inserting 
      
      // Here's where to print out the data structure using toString (problem 2)
      // to see what it looks like before the insertion
      
      if(member(k)) {            // if already present, do nothing! 
         
         // here's where to trace if k is already in the collection
         
         return; 
      }
      
      
      // since k is not a member, we know we will move elements over to make
      // room, so start at end and move over under we get to the insertion point.
      
      for(int i = next-1; i >= -1; --i) {
         db("i is "+ i +" in incert");
         
         // Here's where to trace what i is each time through the loop
         
         if(i == -1) {            // Ran off the left side because inserting new smallest element
            // Here's where to trace if inserting new smallest element
            A[0] = k;
         }
         else if(A[i] <= k) {        // found insertion point; keep moving later elements over to R 
            // Here's where to trace whether you found the insertion point
            A[i+1] = k;
            break;
         }
         else {                          // else just keep moving larger elements to the right
            // Here's where to trace if you are moving elements over
            A[i+1] = A[i];
         }
      } 
      ++next;  
      db(toString());// list has one more element
      
      // Here's where to print out the data structure using toString (problem 2)
      // to see what effect the insert has had.
   } 
 
   
   // delete the first instance of a given int by scanning from left to right; if find the int, then
   // move every later element left one slot
   
   public void delete(int k) {   
      for(int i = 0; i < next; ++i) {
         db("i is " +i+" in delete");
         if(A[i] == k) {      // found it; move later elements over 
            db( A[i]+" is found");
           for(int j = i+1; j < next; ++j) {
               
               A[j-1] = A[j];
            }
            --next;           // list has one fewer element
            break;
         }                    
      } 

   } 
   
   // does binary search on the array using the iterative algorithm 
   
   public boolean member(int k) {  
     
    boolean found = false;   
    int left = 0;
    int right = next - 1;              // search from 0 to end of useful elements (next - 1)
    
    while (left <= right && !found) {
      int middle = (left + right) / 2; 
      if(A[middle] == k)
         found = true;
      else if(k < A[middle])
         right = middle -1;
      else 
         left = middle + 1; 
    } 
        
    return found;
    
   }
   
   // for debugging....  shows the WHOLE array, and puts a "|" at the end of the elements actually
   //   stored
  
  public String toString() { 
     String s = "[";
    for(int i = 0; i < A.length; ++i) {
      if(i == next){
        s += "|" + A[i];
      }
       else if(i == 0)
         s += A[i];
       else {
          s += ", "+A[i];
      }
      
    }
     s +="]";
       return s;
  }

      

     

   
   public int size() {
      return next;
   }
   
   public boolean isEmpty() {
      return (next == 0);
   }
    public static void main(String [] args) { 
      IntCollectionLab C = new IntCollectionLab(10);  // create new collection of size 10
       System.out.println(Arrays.toString(C.A));
      System.out.println("\nTesting size and isEmpty...");
      System.out.println("At beginning should be:\n0  true");
      System.out.println(C.size()+ "  " + C.isEmpty()); 
      System.out.println("\nNow insert two elements and test again; should be:\n2  false");
      C.insert(7);
      C.insert(13);
      System.out.println(C.size()+ "  " + C.isEmpty()); 
      System.out.println("\nNow delete the two elements and test again; should be:\n0  true");
      C.delete(7);
      C.delete(13);
      System.out.println(C.size()+ "  " + C.isEmpty());
      
      System.out.println("\nTesting basic insertions and deletions...");
      System.out.println("\nInserting 8 elements; should be:\n[2, 3, 7, 13, 34, 64, 111, 234 | 0, 0]"); 
      C.insert(64);
      C.insert(2);
      C.insert(7);
      C.insert(34);
      C.insert(3); 
      C.insert(111);
      C.insert(13);
      C.insert(234); 
      System.out.println(C);                    
      System.out.println("\n\nDeleting 2 from front; should be:\n[3, 7, 13, 34, 64, 111, 234 | 234, 0, 0]"); 
      C.delete(2);
      System.out.println(C);  
      System.out.println("\n\nDeleting 234 from end; should be:\n[3, 7, 13, 34, 64, 111 | 234, 234, 0, 0]"); 
      C.delete(234);
      System.out.println(C);  
      System.out.println("\n\nDeleting 13 and 34 from middle; should be:\n[3, 7, 64, 111 | 111, 111, 234, 234, 0, 0]"); 
      C.delete(34);
      C.delete(13);
      System.out.println(C);  
      System.out.println("\nTesting that can not insert duplicates...");
      System.out.println("\nInserting 64 twice more; should be:\n[3, 7, 64, 111 | 111, 111, 234, 234, 0, 0]"); 
      C.insert(64); 
      C.insert(64);   
      System.out.println(C);  
      System.out.println("\nTesting that deleting non-members (-3, 5, 234) should have no effect; Should be:");
      System.out.println("\n[3, 7, 64, 111 | 111, 111, 234, 234, 0, 0]");
      C.delete(-3);
      C.delete(5);
      C.delete(234);
      System.out.println(C);  
      
      System.out.println("\nTesting member......");
      System.out.println("\nChecking member(7); should be:\ntrue");
      System.out.println(C.member(7)); 
      System.out.println("\nChecking member(3); should be:\ntrue");
      System.out.println(C.member(3)); 
      System.out.println("\nChecking member(111); should be:\ntrue");
      System.out.println(C.member(111)); 
      System.out.println("\nChecking member(13); should be:\nfalse");
      System.out.println(C.member(13)); 
      System.out.println("\nChecking member(234); should be:\nfalse");
      System.out.println(C.member(234)); 
           
   }    
} 



     
  // Here's where the unit test goes!





