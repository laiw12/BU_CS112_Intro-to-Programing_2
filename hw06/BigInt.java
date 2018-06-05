/* File: BigInteger.java
 * Date: 10/4/13
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Class: CS 112, Fall 2013
 * Purpose: This is the solution to HW 04, Problem 3, a class which is a container 
 *          for several static methods for manipulating strings of digits as linked 
 *          lists. 
 * Related classes:  interface Stackable.java; Stack.java; Node.java. BigIntegerCalculator.java
 */

public class BigInt  { 
  
  private static class Node {

       public int item;
       public Node next;

       Node() {                 // this would be the default, but if you define another constructor
          item = 0;             // this is not available, so have to provide!
          next = null;      
       } 

       Node(int i) {
          item = i;
          next = null;
       }

       Node(int i, Node p) {
          item = i;
          next = p;
       }
   };
  
  private Node head = null; 
  
  public BigInt() {
    head = new Node(); 
    head.item = 0; 
  }
  
  public BigInt(String s) {
    head = removeLeadingZeros(stringToList(s)); 
  } 
  
  public BigInt(int[] A) {
    head = null; 
    for(int i = 0; i < A.length; ++i) {
      head = new Node(A[i], head); 
    } 
  } 
  
    public BigInt(Node p) {
    if(legalBigIntList(p))
      head = p;
    else
      head = null; 
  } 
  
  public BigInt(int n) {
    int N = numDigits(n); 
    int[] A = new int[N];
    for(int i = 0; i < N; ++i) {;
      A[i] = n%10;
      n = n / 10;
    }
    
    head = null; 
    for(int i = A.length-1; i >= 0; --i) {
      head = new Node(A[i], head); 
    }       
  } 

  private static int numDigits(int n) {
    if(n == 0)
      return 1;
    else
      return (int)Math.floor(Math.log10(n))+1;
  }
   
   // returns true iff s is a non-empty string of digits; note can not be a negative integer!
   public static boolean legalBigInt(String s) {
      
      if(s.length() == 0)                           // special case!
         return false; 
      
      for(int i = 0; i < s.length(); ++i)
         if(s.charAt(i) < '0' || s.charAt(i) > '9')
         return false;
      
      return true;     
   }
   
   // returns true iff s is a non-empty LL of digits
   private static boolean legalBigIntList(Node s) {
      if(s == null)
         return false; 
      
      for(Node p = s; p != null; p = p.next)
         if(p.item < 0 || p.item > 9)
         return false; 
      
      return true;     
   }
   
   // turn a String of digits into a reverse list of ints (one int = one digit)
   
   public static Node stringToList(String s)  {  
      
      if(!legalBigInt(s))
         return null; 
      
      Node p = null; 
      
      for(int i = 0; i < s.length(); ++i)
         p = new Node((s.charAt(i) - 48), p);
      
      return p; 
   }
   
   // returns the string representation of a BigInt linked list
   
   public static String listToString(Node p)  {
      
      if(!legalBigIntList(p))
         return null; 
      
      String s = ""; 
      for(Node q = p; q != null; q = q.next)
         s = q.item + s; 
      
      return s;  
   }
   
      public String toString()  {
      
           return listToString(head);   
   }
   
  public BigInt add(BigInt B) {
    return new BigInt( removeLeadingZeros( add(head, B.head) ) );
  }
  
    public BigInt mult(BigInt B) {
    return new BigInt( removeLeadingZeros( mult(head, B.head) ) );
  }

    
  public BigInt incr() {
    return   this.add(new BigInt(1)  ) ; 
  }

  public int compareTo(BigInt B) {
    if(length(head) > length(B.head))
      return 1;
    else if(length(head) < length(B.head))
      return -1;
    return compareTo(reverse(head), reverse(B.head));
  } 
  
  private int compareTo(Node p, Node q) {
    if(p == null && q == null)
      return 0; 
    else if (p.item > q.item)
      return 1;
    else if (p.item < q.item)
      return -1;
    else
      return compareTo(p.next, q.next);
  }

  private int length(Node p) {
    if(p == null)
      return 0;
    else
      return 1 + length(p.next); 
  }

  
   public static Node reverse(Node p) {
      return reverseHelper(p, null);
   }
   
   public static Node reverseHelper(Node p, Node q) {          // p is a stack that we pop from, and q a stack we push onto
      if(p == null)
         return q;                                             // when p is null, we are done and return q.
      else {
         Node rest = p.next;                                   // pop p off and save rest of list
         p.next = q;                                           // push the node p onto the list q
         return reverseHelper(rest, p);                        // continue
      }
      
   }
   
   
   // add big ints p and q represented as reversed lists of digits, and returns the sum 
   
   public static Node add(Node p, Node q)  {
      if( !legalBigIntList(p) || !legalBigIntList(q) )
         return null; 
      return removeLeadingZeros(addWithCarry(p, q, 0));                  // carry into first position is 0
   }
   
   // add big ints p and q with carry from previous position
   // helper method for previous
   
   private static Node addWithCarry(Node p, Node q, int k) {
      int sum, carry; 
      if(p == null) 
         return addCarry(q,k);
      else if(q == null)
         return addCarry(p,k);
      else {
         sum = p.item + q.item + k;
         carry = sum / 10; 
         sum = sum % 10; 
      }
      return new Node(sum, addWithCarry(p.next,q.next,carry)); 
   }
   
   // add bigint and scalar (only necessary to propagate carry)
   // helper method for previous 
   private static Node addCarry(Node p, int k) {
      int carry = 0; 
      if(p == null && k == 1)
         return new Node(1); 
      else if(p == null)
         return null; 
      else {
         int sum = p.item +  k;
         if(sum > 9) {
            carry = sum / 10; 
            sum = sum % 10; 
         }
         return new Node(sum, addCarry(p.next,carry)); 
      }
   }
   
   
   // p is multiplicand, q is multiplier; cleanup will remove any leading zeros
   
   public static Node mult(Node p, Node q) {
      if( !legalBigIntList(p) || !legalBigIntList(q) )
        return null; 
      return removeLeadingZeros(multAux(p,q)); 
   }
   
   public static Node multAux(Node p, Node q) {
      if(q == null)
         return new Node(0); 
      else {
         return addWithCarry(multByScalar(p,q.item),
                             multAux(new Node(0,p),
                                     q.next),
                             0
                            ); 
      }
   }
   
   // multiply p by scalar k
   private static Node multByScalar(Node p, int k) {
      return multByScalarAux(p, k, 0);
   }
   
   private static Node multByScalarAux(Node p, int k, int c) {
      int prod, carry; 
      if(p == null && c != 0)
         return new Node(c);
      else if(p == null)
         return null; 
      else {
         prod = p.item * k + c;
         carry = prod / 10; 
         prod = prod % 10; 
      }
      return new Node(prod, multByScalarAux(p.next,k,carry)); 
   } 
   
   // removes leading zeros which may be produced by mult
   //  remember that lists are reversed!
   
   public static Node removeLeadingZeros(Node p) {
      p.next = remHelper(p.next);       // never remove low-order node!
      return p;
   }
   
   // will delete any trailing 0's
   public static Node remHelper(Node p) {
      if(p == null)
         return null;
      p.next = remHelper(p.next); 
      if(p.next == null && p.item == 0)
         return null;
      else
         return p; 
   }
   
   // just a debugging print method for LLs
   
   private static void printList(Node p) {
      for(Node q = p; q != null; q = q.next)
         System.out.print(q.item + " -> ");
      System.out.println("."); 
   }
   
   // unit test
   
   public static void main(String [] args) {
     BigInt B = new BigInt("4431"); 

     System.out.println(B); 
          BigInt C = new BigInt("4430"); 

     System.out.println(C.incr().incr()); 

 
     
     
     
   }
   
}