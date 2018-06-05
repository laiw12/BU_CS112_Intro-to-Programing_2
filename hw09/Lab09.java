/* File: Lab09.java
 * Author: Lai Wei
 * Date: 4/2/2015
 * Purpose: This is the  code for Lab 09
 */

public class Lab09 {
  
  // Basic Node definition: you will need to modify this for problems 1 and 2
  
  public static class Node {
    int key;
    int counter =0;
    Node parent;
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
  
  
  // Problem Zero: You must create six versions of this method, for Pre-, In-, and Postorder traversals
  // normal and reverse
  
  public static void traverse(Node t) {
    if(t != null) {
      traverse(t.left);             
      visit(t);                           
      traverse(t.right);           
    }
  } 
  
  
  
  
  public static void inorder(Node t) {
    
    if(t != null) {
      inorder(t.left);             
      visit(t);                           
      inorder(t.right);           
    }
  } 
  
  
  
  public static void preorder(Node t) {
  
    
    
    if (t!=null){
      visit(t);
      preorder(t.left);
      preorder(t.right);
  } 
  }
  

public static void postorder(Node t) {
    if(t != null) {
      postorder(t.left);                                       
      postorder(t.right); 
      visit(t); 
    }
  } 
    
    
    
 
    public static void reversePostorder(Node t) {
    if(t != null) {
      reversePostorder(t.right); 
      reversePostorder(t.left);             
      visit(t); 
    }
  }
 
       public static void reverseInorder(Node t) {
    if(t != null) {
      reverseInorder(t.right);            
      visit(t);                           
      reverseInorder(t.left); 
    }
  } 
  
      
  
  
 public static void reversePreorder(Node t) {       // rename this as preorder
    if(t != null) {
      visit(t); 
      reversePreorder(t.right); 
      reversePreorder(t.left);                   
    }
  } 
  
  
  
  
  public static void visit(Node t) {
    System.out.print(t.key + " ");
  }
  
  
  // Problem One: You must modify the this method and its helper to account for parent pointers
  
  public static Node insert(Node t, int key) {
     return insertHelper(t,key);
     
     
  }
  
  public static Node insertHelper(Node t, int key) {
    if (t == null)
      return new Node(key);
    else if (key < t.key) {
      t.left = insertHelper(t.left, key);
      t.left.parent = t;
      return t;
    } else if (key > t.key) {
      t.right = insertHelper(t.right, key);
      t.right.parent =t;
      return t;
    } else
      return t;
  }
  
  
  // Problem Two: You must complete this method
  // The parameter order indicates which traversal method: 1 = Preorder, 2 = Inorder, and 3 = Postorder
  // The parameter normal = true for a normal traversal (L to R) and false for a reverse (R to L)
  
 public static void traverse(Node t, int order, boolean normal) {
    Node p = t; 
    while(p != null) {
      
      p.counter += 1; 
      
      if (order == p.counter)
        visit(p); 
      
      
      if(normal) {
        if(p.counter == 1 && p.left != null)
            p = p.left;  
        else if(p.counter == 2 && p.right != null) 
            p = p.right;
        else if(p.counter == 3) { 
          p.counter = 0;            
          p = p.parent;              
        }
      }
      else {                          
        if(p.counter == 1 && p.right != null)
            p = p.right;  
        else if(p.counter == 2 && p.left != null) 
            p = p.left;
        else if(p.counter == 3) { 
          p.counter = 0;           
          p = p.parent;              
        }       
      }
    }
 }
    
      
      
  
    
      
    
    







  
  
  // For debugging: recursively print out a diagram of the tree sideways
  
  public static void printTree(Node t) {
    System.out.println();
    printTreeAux(t, "");
    System.out.println();
  }
  
  public static void printTreeAux(Node t, String indent) {
    if (t != null) {
      printTreeAux(t.right, indent + "   "); // add three spaces to indent
      if(t.parent != null)
        System.out.println(indent + t.key + "   (" + t.parent.key + ")" );
      else
      System.out.println(indent + t.key);
      printTreeAux(t.left, indent + "   "); // add three spaces to indent
    }
  }
  
  public static void main(String[] args) {
         // create a tree similar to one from lecture, but 1 instead of A, 2 instead of B, etc. 
    Node root = null; 
    root = insert(root,6); 
    root = insert(root,2); 
    root = insert(root,7); 
    root = insert(root,1); 
    root = insert(root,4); 
    root = insert(root,3); 
    root = insert(root,5); 
    root = insert(root,9); 
    root = insert(root,8); 
    
    printTree(root); 
    System.out.println("Basic traversal:  for null tree:"); 
    traverse(null);
    System.out.println(); 
    
    System.out.println("Basic traversal:  for example tree:"); 
    traverse(root);
    System.out.println();
    
    // Now do 7 tests of your iterative traversal method, one for a null tree
    // and 6 for each of the basic traversals; for each you should print out
    // the name of the traversal, then print out the tree using the recursive traversal
    // then with the iterative traversal. They should be the same!
   
        System.out.println("\nPreorder Traversal of null tree:"); 
    preorder(null);
    System.out.println(); 
    traverse(null,1,true);
    System.out.println();  
    
    System.out.println("\nPreorder Traversal:"); 
    preorder(root);
    System.out.println(); 
    traverse(root,1,true);
    System.out.println();   
    
    System.out.println("\nInorder Traversal:"); 
    inorder(root);
    System.out.println(); 
    traverse(root,2,true);
    System.out.println(); 
    
    System.out.println("\nPostorder Traversal:"); 
    postorder(root);
    System.out.println(); 
    traverse(root,3,true);
    System.out.println(); 
    
    System.out.println("\nReverrse preorder Traversal:"); 
    reversePreorder(root);
    System.out.println(); 
    traverse(root,1,false);
    System.out.println();   
    
    System.out.println("\nReverse inorder Traversal:"); 
    reverseInorder(root);
    System.out.println(); 
    traverse(root,2,false);
    System.out.println(); 
    
    System.out.println("\nReverse postorder Traversal:"); 
    reversePostorder(root);
    System.out.println(); 
    traverse(root,3,false);
    System.out.println();
    
  }
  

    
    
    
    // Now do 7 tests of your iterative traversal method, one for a null tree
    // and 6 for each of the basic traversals; for each you should print out
    // the name of the traversal, then print out the tree using the recursive traversal
    // then with the iterative traversal. They should be the same!
    
    
 
    
   }
  

