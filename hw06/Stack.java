/* File:IntStack.java
 * Date: 2/25/14
 * Author:  Lai Wei
 * Class: CS 112, Spring 2015
 * Purpose: This is my homework 6 problem B4.
 */
@SuppressWarnings("unchecked")




public class Stack <Item>{
 final int SIZE = 100; 
  
  private Item [] S =(Item []) new Object [100];                                      // initialize S
  private int next=0;


  // push an integer on the stack
  public  void push(Item n){
    S[next] = n;
    ++next;
  }
  
  // pop an interger off the stack
  public Item pop(){
    
      --next;
      Item n = S[next];
        return n;
  }

// check if the stack is empty
  public boolean isEmpty(){
    return next ==0;
  }
  
 // return the length of the stack
  public int size(){
  return next;
}
  // print out the stack
  public String toString(){


 String a="";
   for(int i=next-1;i>=0;--i){
     a = a + String.valueOf(S[i]) + "\n";
   }
     
     a = a + "__" + "\n";
       return a;
  }
}