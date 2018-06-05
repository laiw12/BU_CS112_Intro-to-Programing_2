public class test{
                       public static int[] addzero(int[] A1,int[]B){                                  //  my helper function. Inputs two array of integers and add leading zeros to the shorter array
      int [] B1 = new int[A1.length];                                            // for example if 234 and 23 are put in. 023 will be returned
      int [] B2 = new int[B.length];
  if ( A1.length > B.length){ 
     
      for(int i =0; i<A1.length-B.length; ++i){
        B1[i]=0;
      }
      for(int i =0; i < B.length; ++i){
        B1[A1.length-B.length+i] = B[i];
      }
      return B1;   
      }
if (A1.length < B.length){
  for(int i = 0; i<B.length-A1.length;++i){
    B2[i]=0;
  }
  for (int i =0; i<A1.length;++i){
    B2[B.length-A1.length+i]= A1[i];
  }
  return B2;
}
else
  return A1;
}                                   
  
 public static int[] add(int[] A1, int[] B) {
    int carrybit =0;                                                                    // with my helper function add zero, I can have two array which have the same length
     int test[] = new int[A1.length+1];                                                    // So that I can use for loop to add tha single elements in the array 
     int A2 [] = addzero(A1,B);                                                              
     if(B.length > A1.length){ 
       test = add(B,A1);
       return test;
     }
     if(B.length < A1.length){
         for(int i= A1.length-1;i>=0;--i){
        if (A1[i] + A2[i]+carrybit >=10){
          test[i+1] = A1[i]+A2[i]-10+carrybit;
            carrybit=1;
        }
        if (A1[i] + A2[i] + carrybit<10){
          test[i+1] = A1[i]+ A2[i] +carrybit;
            carrybit=0;
        }
        test[0] = carrybit;
      }
    return test;
     }
     else{
        for(int i= A1.length-1;i>=0;--i){
        if (A1[i] + B[i]+carrybit >=10){
          test[i+1] = A1[i]+B[i]-10+carrybit;
            carrybit=1;
        }
        if (A1[i] + B[i] + carrybit<10){
          test[i+1] = A1[i]+ B[i] +carrybit;
            carrybit=0;
        }
        test[0] = carrybit;
      }
    return test;
    }
  }





public static void main(String [] args) {
  int [] a = {7,6,0};
  int [] b ={4,2};
  int [] c =addzero(a,b);
  int [] d =add(a,b);
  for(int i=0;i<c.length;++i){
    System.out.print(c[i]);
  }
  System.out.print("\n");
  for(int i=0; i<d.length;++i){
    System.out.print(d[i]);
  }


  
}
}