public class test{  
 
 void swapTwo(Stack S){
    if (S.isEmpty()){
    }
   int a= S.pop();
      if (S.isEmpty()){
        S.push(a);
        }
      else{
        int b =S.pop();
        int c =S.pop();
        S.push(b);
        S.push(c);
      }
 }
      
    
    
    
    
    
  
public static void main(String[] args) {
     int a = 5/2;
     System.out.println(a);
     if (a > 0){
     }
     else{
       a =5;
   }
     System.out.println(a);
}
}