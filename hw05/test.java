public class test{
  public  static void swap( int [] arr, int i, int j)
  { int a =arr[i];
    int b = arr[j];
    arr[i] =b;
    arr[j] = a;
  }
    
  public static  void insertion(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        for (int j = i; j > 0; j--) {
          if (arr[j] < arr[j - 1]){
             swap(arr, j, j - 1);
                 for(int x=0;x <arr.length;++x)
                  System.out.print(" " + arr[x]);
                // show array here
        }
          
            System.out.print("\n");
    }
       
}
  }
    public static void selection(int[] arr) {
    int k;
    for (int i = 0; i < arr.length; i++) {
        k = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[k])                            
                k = j;
        }
        swap(arr, i, k);
        for(int x=0;x <arr.length;++x){
                  System.out.print(" " + arr[x]);
        // show array here
    }
    System.out.print("\n");
}
    }
    
  
   public static void main(String[] args) {
     int [] a = new int[6];
     a[0] = 9;
     a[1] = 6;
     a[2] = 4;
     a[3] = 2;
     a[4] = 3;
     a[5] = 1;
     
     selection(a);
     
   }
}
     
     