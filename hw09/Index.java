/* File: Index.java
 * Author: Lai Wei
 * Date: 4/6/15
 * Purpose: This is the solution for Problem B.2, HW09, CS 112, Spring 2015
 */

import java.io.*;
import java.util.*;

public class Index { 
  
  // Nodes for linked lists of values
  private  class Node {
    String value;
    Node next;
    
    public Node(String v) {
      value = v;
    }
    
    
    // Constructor(s) and toString (if you want to use it) go here
  }
  
  
  // nodes for the binary tree
  private class TreeNode {
    String key;
    Node values;
    TreeNode left;
    TreeNode right;
    
    public TreeNode( String w){
      key = w;
      values=null;
    }
    public TreeNode(String w, String s){
      key=w;
      values = new Node(s);
      
    }
    // Get a String represetaion of a TreeNode.
    public String toString(){
      String s = key+":[";
      Node p =values;
      if(p==null){
        return s+"]";
      }
      while(p!=null){
        if(p.next==null){
          s=s+p.value+"]";
          return s;
        } 
        else{
          s = s +p.value+":";
          p=p.next;
        }
      }
      return s;
    }
  }
  
  
  

  
  
  
  
 private TreeNode root = null;
  
  
  // Standard utility methods
  
  
  // Size is number of nodes in the tree
  public int size() {
    return size(root);
  }
  
  private int size(TreeNode t) {
    if (t == null)
      return 0;
    else
      return 1 + size(t.left) + size(t.right);
  }
  
  // Height of a binary tree is number of links in longest path, note that
  //     empty tree has height -1.
  
  public int height() {
    return height(root);
  }
  
  private int height(TreeNode t) {
    if (t == null)
      return -1;
    else 
      return 1 + Math.max( height(t.left), height(t.right) ); 
  }
  
  public void printTree() {
    printTree(root, "");  
  }
  
  private void printTree(TreeNode t, String indent) {
    if(t != null) {
      printTree(t.right, indent + "\t");
      System.out.println(indent + t); 
      printTree(t.left, indent + "\t"); 
    }
  }
  
  public void printTreeKeys() {
    printTreeKeys(root, "");  
  }
  
  private void printTreeKeys(TreeNode t, String indent) {
    if(t != null) {
      printTreeKeys(t.right, indent + "\t");
      System.out.println(indent + t.key); 
      printTreeKeys(t.left, indent + "\t"); 
    }
  }
  
  
  
  // Other helper methods.
  // my helper function contain(...) method to check if var is in the link list.
  public  boolean contains(Node p,String var){
    if(p==null){
      return false   ;
    }
    if(p.value != var){
      
      return contains(p.next,var);
    }
    else 
      return  true;
  }
  
  // my helper function to insert a Node containng the value var in to a node.
  public  Node insertNode(Node p, String var){
    if(p==null){
      return new Node(var);
    }
    if(contains(p,var)){
      return p;
    }
    else
      p.next= insertNode(p.next, var);
    return p;
  }
  
  //
  
  // Interface methods
  // Remove the key and all its values from the tree;if the key is not in the tree, do nothing.
  public void delete(String key) {
    root=delete(key,root);
  }
  
  
  // I change the delete code provided by Professor a little bit in order to adapt the TreeNode class.
  public TreeNode delete(String key, TreeNode t) {
    if (t == null)                             // Case 1: tree is null
      return t;
    else if (key.compareTo(t.key) < 0) {                      // Case 2: key n is in left subtree
      t.left = delete(key, t.left);
      return t;
    } else if (key.compareTo(t.key) > 0) {                    // Case 3: key n is in right subtree
      t.right = delete(key, t.right);
      return t;
    } else                                     // Case 4: found key n at root; 
      if (t.left == null)                // Case 4a: no left child, so reroute around this node
      return t.right;
    else if (t.right == null)                  // Case 4b: no right child, ditto
      return t.left;
    else {                                     // Case 4c: both children exist, so move minimal key in right subtree up 
      TreeNode min = findMin(t.right);             //    Preserve a pointer to this minimal node and then
      t.right = deleteMin(t.right);            //    reconstruct the right subtree without it
      min.left = t.left;                       //    Finally, replace root node with min node
      min.right = t.right;
      return min;
    }
  }
  //Finde the minimal TreeNode.
  public  TreeNode findMin(TreeNode r) {
    if(r.left == null)          // this is the minimal node
      return r;
    else
      return findMin(r.left);
  }
  
  // reconstruct the tree r without its minimal element
  public TreeNode deleteMin(TreeNode r) {
    if(r.left == null)
      return r.right;
    else {
      r.left = deleteMin(r.left);
      return r; 
    } 
  }
  
  
  
  
  //  Insert a new TreeNode with the given key, and a null list of values; if the key is already in the tree, do nothing. 
  public void insert(String key) {
    root = insertHelper(key,root);
  }
  // Helper function for my insert method.
  private TreeNode insertHelper(String key,TreeNode t){
    
    if (t == null)
      return new TreeNode(key);
    else if (key.compareTo(t.key)<0) {
      t.left = insertHelper( key,t.left);
      return t;
    } else if (key.compareTo(t.key) > 0) {
      t.right = insertHelper( key,t.right);
      return t;
    } else
      return t;
  }
  
  //If the key is already in the table, add  val to the list of values; but if val is already
  // the list of values, do nothing; If the key is not in the table, insert a new TreeNode
  // and create a linked list for the values, containing a single node with val.      
  
  public void insert(String key, String val) {
    
    root =insertHelper1( key,val,root);
  }
  
  // My helper method of insert(String key, String val)
  private TreeNode insertHelper1(String key,String val,TreeNode t){
    if (t == null){
      return new TreeNode(key,val);
    }
    
    if(t.key==key){
      t.values= insertNode(t.values,val);
      
      return t;
    }
    else if (key.compareTo(t.key)<0) {
      t.left = insertHelper1( key,val,t.left);
      return t;
    } else if (key.compareTo(t.key) > 0) {
      t.right = insertHelper1( key,val,t.right);
      return t;
    } else
      return t;
  }
  
  
  //The functionality of this is the same as the last,except all the values to the linked list of values;
  public void insert(String key, String[] values) {
    for(int i=0;i<values.length;++i){
      insert(key,values[i]);
    }
  }
  
  
  
  
  // my helper function of getValues(...) to find a TreeNode that contains the key and returns the TreeNode.
  
  public  TreeNode find(TreeNode t, String key) {
    if (t == null)
      return null;
    else if (key.compareTo(t.key) < 0) {
      return find(t.left, key);
    } else if (key.compareTo(t.key)>0 ) {
      return find(t.right, key);
    } else
      return t;
  }
  
  
  
  //Return a String representation of the values associated withthe key; if the key is not in the table, return null; if
  // the list of values is null, return "[]". 
  public String getValues(String key) { 
    TreeNode q =find(root,key);
    String s="["; 
    if (q== null){
      return null;
    }
    if(q.values==null){
      return "[]";
    }
    else{
      Node p = q.values;
      while(p.next!=null){
        s=s+p.value+":";
        p=p.next;
      }
      s=s+p.value+"]";
      return s;
    }
  }
  
  // my helper method for getInvertedIndex();
  private void invertedHelper( TreeNode r,Index NewTable){
    if(r!=null){
   
      Node q =r.values;
      while(q!=null){
        NewTable.insert(q.value,r.key);
        q=q.next;
      }
            invertedHelper(r.left,NewTable);
      
        invertedHelper(r.right,NewTable);
   
            
    }
    
  }
  
  // methods to build inverted index
  
  public Index getInvertedIndex() {
    Index NewTable = new Index();
    invertedHelper(root,NewTable);
    return NewTable;
  }
  
  
  
  // unit test
  
  public static void main (String[] args) { 
    
    
    
    
    
    Index D = new Index(); 
    String[][] V = {
      {"Coke", "Salad", "Pasta" },            
      {"Pepsi", "Salad", "Chicken", "Salad" },   // Node duplicate value 
      {"Chicken", "Pasta"} };
    
    D.insert("Ringo",  V[0]);
    D.insert("John",  V[1]);
    D.insert("George", V[2]);
    D.insert("George", "Pasta");       // duplicate, should not be inserted
    D.insert("George", "Milk");
    D.insert("Wayne"); 
    D.insert("Paul"); 
    D.insert("Paul", "Pasta");
    D.insert("Paul", "Beef");
    D.insert("Paul", "Coke");
    D.insert("Paul", "Pasta");         // duplicates, should not be inserted
    D.insert("Paul"); 
    D.insert("Wayne"); 
    
    
    System.out.println("\n[1] Printing keys of tree, should be:\n");
    System.out.println("\tWayne\n"
                         + "Ringo\n"
                         + "\t\tPaul\n"
                         + "\tJohn\n" 
                         + "\t\tGeorge\n");
    
    D.printTreeKeys(); 
    
    System.out.println("\n[2] Printing tree, should be:\n");
    System.out.println("\tWayne:[]\n"
                         + "Ringo:[Coke;Salad;Pasta]\n"
                         + "\t\tPaul:[Pasta;Beef;Coke]\n"
                         + "\tJohn:[Pepsi;Salad;Chicken]\n" 
                         + "\t\tGeorge:[Chicken;Pasta;Milk]\n");
    
    D.printTree(); 
    
    System.out.println("\n[3]: Testing size, should print out:\n5");
    System.out.println(D.size()); 
    
    System.out.println("\n[4]: Testing height, should print out:\n2");
    System.out.println(D.height());
    
    System.out.println("\n[5]: Testing getValues, should print out:\n[Chicken;Pasta;Milk]");
    System.out.println(D.getValues("George")); 
    
    System.out.println("\n[6]: Testing getValues, should print out:\n[]");
    System.out.println(D.getValues("Wayne")); 
    
    System.out.println("\n[7]: Testing getValues, should print out:\nnull");
    System.out.println(D.getValues("Ozzy")); 
    
    System.out.println("\n[8]: Testing delete, should print out:\n");
    System.out.println("Wayne\n"
                         + "\t\tPaul\n"
                         + "\tJohn\n"
                         + "\t\tGeorge\n");
    D.delete("Ringo"); 
    D.printTreeKeys();  
    
    System.out.println("\n[9]: Testing getValues, should print out:\nnull");
    System.out.println(D.getValues("Ringo"));  
    
    System.out.println("\nBuilding Inverted Index....\n"); 
    Index InvD = D.getInvertedIndex(); 

    System.out.println("[10] Printing tree, should be:\n");
    System.out.println("\tSalad:[John]\n"
                         + "Pepsi:[John]\n"
                         + "\t\tPasta:[George;Paul]\n"
                         + "\t\t\tMilk:[George]\n"
                         + "\t\t\t\tCoke:[Paul]\n"
                         + "\tChicken:[John;George]\n"
                         + "\t\tBeef:[Paul]\n");
    
    InvD.printTree(); 
    
    System.out.println("\n[12]: Testing size, should be:\n7");
    System.out.println(InvD.size()); 
    
    System.out.println("\n[13]: Testing height, should be:\n4");
    System.out.println(InvD.height()); 
    
    System.out.println("\n[14]: Testing getValues, should be:\n[George;Paul]");
    System.out.println(InvD.getValues("Pasta")); 
    
    System.out.println("\n[15]: Testing getValues, should be:\nnull");
    System.out.println(InvD.getValues("Pork"));
  
    
    
    
  }
}