/* File: AverageCaseBST.java
 * Author: Lai Wei
 * Date: 2/28/15
 * Purpose: This is the Solution for Problem B.2 in HW 06 in CS 112, Spring 2015
 */

// Answer for the first question: It is theta(log(N)) for the first question.
// Answer for the second question: The value of C is 3. The final result is ~(3*log(N)).


import java.util.Random;
import java.awt.Color; 

public class   AverageCaseBSTs {
   public static class Node {
  int key;
  Node left;
  Node right;

  public Node(int k) {
   left = null;
   right = null;
   key = k;
  }

  public Node(int k, Node left, Node right) {
   key = k;
   this.left = left;
   this.right = right;

  }
 }

 // Size is number of nodes in the tree

   public static int size(Node t) {
  if (t == null)
   return 0;
  else
   return 1 + size(t.left) + size(t.right);
 }


   // Height of a binary tree is number of links in longest path, note that
   //     empty tree has height -1.

 public static int height(Node t) {
     if (t == null)
     return -1;
  else 
          return 1 + Math.max( height(t.left), height(t.right) ); 
 }


   public static boolean member(Node t, int key) {
  if (t == null)
   return false;
  else if (key < t.key) {
   return member(t.left, key);
  } else if (key > t.key) {
   return member(t.right, key);
  } else
   return true;
 }


 // Find a node with a given key and return a pointer to it or null if not found
   //    This can be used to implement get(...) from the textbook

   public static Node lookup(Node t, int key) {
  if (t == null)
   return null;
  else if (key < t.key) {
   return lookup(t.left, key);
  } else if (key > t.key) {
   return lookup(t.right, key);
  } else
   return t;
 }



   // Recursively insert into tree, same as put(....) from the textbook

 public static Node insert(Node t, int key) {
  if (t == null)
   return new Node(key);
  else if (key < t.key) {
   t.left = insert(t.left, key);
   return t;
  } else if (key > t.key) {
   t.right = insert(t.right, key);
   return t;
  } else
   return t;
 }

   // Recursively reconstructs tree without the key n in it

 public static Node delete(int n, Node t) {
   if (t == null)                             // Case 1: tree is null
     return t;
   else if (n < t.key) {                      // Case 2: key n is in left subtree
     t.left = delete(n, t.left);
     return t;
   } else if (n > t.key) {                    // Case 3: key n is in right subtree
     t.right = delete(n, t.right);
     return t;
   } else                                     // Case 4: found key n at root; 
           if (t.left == null)                // Case 4a: no left child, so reroute around this node
     return t.right;
   else if (t.right == null)                  // Case 4b: no right child, ditto
     return t.left;
   else {                                     // Case 4c: both children exist, so move minimal key in right subtree up 
     Node min = findMin(t.right);             //    Preserve a pointer to this minimal node and then
     t.right = deleteMin(t.right);            //    reconstruct the right subtree without it
     min.left = t.left;                       //    Finally, replace root node with min node
     min.right = t.right;
     return min;
   }
 }
 
 // return a pointer to the minimal element in r
 
 public static Node findMin(Node r) {
   if(r.left == null)          // this is the minimal node
     return r;
   else
     return findMin(r.left);
 }
 
 // reconstruct the tree r without its minimal element
 
 public static Node deleteMin(Node r) {
   if(r.left == null)
     return r.right;
   else {
     r.left = deleteMin(r.left);
     return r; 
   } 
 }

   // Recursively traverse the tree, printing out the keys, one per line; by changing order
   //    of statements, can get all 6 traversals:
   //    
   //    Preorder          V L R
   //    Inorder           L V R
   //    Postorder         L R V
   //    Reverse Preorder  V R L
   //    ReverseInorder    R V L
   //    ReversePostorder  R L V

   public static void traverse(Node t) {
       if(t != null) {
           traverse(t.left);             // L
           visit(t);                     // V
           traverse(t.right);            // R
       }
   } 

   public static void visit(Node t) {
      System.out.println(t.key);
   }

   // Recursively print out a diagram of the tree sideways

 public static void printIndentedTree(Node t) {
  System.out.println();
  printIndentedTreeAux(t, "");
  System.out.println();
 }

    public static void printIndentedTreeAux(Node t, String indent) {
     if (t != null) {
       printIndentedTreeAux(t.right, indent + "   "); // add three spaces to indent
       System.out.println(indent + t.key);
       printIndentedTreeAux(t.left, indent + "   "); // add three spaces to indent
     }
    }
    
private static int runBSTInsertion(int N) {
        int sum=0;
        for(int j=0; j<1000;++j){
          Node B =null;
          int[] A = genRandomArray(N);
          for(int i = 0; i < N; ++i) {
             B= insert(B,A[i]);
          } 
          sum = sum+height(B);
        }
           return sum/1000;
    }
    
    
    
     private static Random R = new Random(); 
  
  private static int[] genRandomArray(int size) {
    int[] B = new int[size];
    for(int i = 0; i < size; ++i)
      B[i] = R.nextInt(10000); 
    return B; 
  }
  
    private static void drawGraphs() {
    int N = 100;
    
    double pointRadius = 0.005;
    double lineRadius = 0.001;
    
    StdDraw.setXscale(0, N);
    StdDraw.setYscale(0, 10*N);
    StdDraw.setPenRadius(pointRadius);
    StdDraw.setPenColor(Color.black);       // Google "Java Color"; the first link gives all the colors
    StdDraw.line(0,0,0,10*N); 
    StdDraw.line(0,0,N,0);
    
     double prevX, prevY;
     
    StdDraw.setPenColor(Color.blue);
    prevX = 0; prevY = 0; 
    for (int i = 1; i <= N; i++) {
      int y = runBSTInsertion(i); 
      StdDraw.setPenRadius(pointRadius);
      StdDraw.point(i, y);
      StdDraw.setPenRadius(lineRadius);
      StdDraw.line(prevX, prevY, i, y);
      prevX = i; prevY = y;
    }
    
    
   StdDraw.setPenColor(Color.black);
   prevX = 0 ; prevY=0;
   for (int i =1; i<=N;i++){
     
      StdDraw.setPenRadius(pointRadius);
      StdDraw.point(i,3* Math.log(i));
      StdDraw.setPenRadius(lineRadius);
      StdDraw.line(prevX, prevY, i,3* Math.log(i));
      prevX = i; prevY =3* Math.log(i);
    }
    }
     
     
   
   
  
  
  
  
  

  
  public static void main(String[] args) {
    
    drawGraphs(); 
    

    
    
  }
  
}