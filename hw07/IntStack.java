/* File: IntStack.java
  * Classes: IntStack
  * Date: 3/19/15
  * Class: Boston University CS 112, Spring 2015
  * Author: Lai Wei
  * Purpose: This is my HW07 Problem B1
  */

public class IntStack  {
  
  private int [] A = new int[5]; 
  
  private int next = 0;                        // location of next available unused slot  
  
  // interface methods
  
  public void push(int key) throws OverflowException { 
    if (next==5){
           throw new OverflowException("Stack Overflow! Cannot push ",key)  ; 
    }// push the key onto the top of the stack 
    A[next++] = key; 
  }
  
  public int pop() throws UnderflowException {    
    if (next==0){
           throw new UnderflowException("Stack Underflow!");  
    }// remove the top integer and return it -- will cause error if empty! 
    return A[--next];   
  }
  
  public boolean isEmpty() {
    return (next == 0); 
  }
  
  public int size() {                 // how many integers in the stack 
    return next; 
  }
  
  // unit test
 
  public static void main(String [] args) {
    
    IntStack S = new IntStack(); 
    try{
      System.out.println("Pushing 5, 9, 9, -3, 31 then popping and printing it out:"); 
    S.push(5); S.push(9); S.push(9); S.push(-3); S.push(31);
    
    while(!S.isEmpty()) {
       System.out.println(S.pop()); 
    }
    
    // this one will cause an error!
    System.out.println(S.pop());
    
    }
  
   
      
    catch(Exception e){
         System.out.println(e.getMessage());
    }
      
 
  try{
        // So will this one!
    System.out.println("Pushing 5, 9, 9, -3, 31, and 99 then popping and printing it out:"); 
    S.push(5); S.push(9); S.push(9); S.push(-3); S.push(31); S.push(99);
  
  }
     catch (Exception e){

      System.out.println(e.getMessage());

    }
  


  }

  }
//UnderflowException
  class UnderflowException extends Exception {
    public int num;
    public UnderflowException (String msg) {
        super(msg);
       
    }
}
//OverflowException
    class OverflowException extends Exception{

    public int num;

    public OverflowException(String msg, int n){

      super(msg+n);

      num=n;

  }
  
}


