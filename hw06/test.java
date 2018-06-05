public class test{
public static boolean less(int v, int w) {
    return v < w; 
  }

public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  
  public static int partition(int[] A, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int v = A[lo];
    while (true) { 
      
      // find item on lo to swap
      while (less(A[++i], v))
        if (i == hi) break;
      
      // find item on hi to swap
      while (less(v, A[--j]))
        if (j == lo) break;      // redundant since A[lo] acts as sentinel
      
      // check if pointers cross
      if (i >= j) break;
      
      swap(A, i, j);
    }
    
    // put partitioning item v at A[j]
    swap(A, lo, j);
    
    // now, A[lo .. j-1] <= A[j] <= A[j+1 .. hi]
    
    for(int z = 0; z <A.length;++z){
      System.out.print(A[z]);}
    System.out.print("\n");
    return j;
  }
  
  public static  void main(String[] args) {
    int [] M = new int[6];
    M[0] = 2;
    M[1] = 4;
    M[2] = 8;
    M[3] = 5;
    M[4] =7;
    M[5] = 9;
  
    
     int x = partition(M, 0, 5);
     System.out.println(x);
  }
}
    
    
 