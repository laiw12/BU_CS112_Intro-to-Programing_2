public class test01{
  public static void main(String[] args){
    int a= 1234;
    System.out.println(1234%10);
    

  if(n<0){
       char[] x = new char[(int)(Math.log10(n)+2)];
       n=n*(-1);
       for(int i = x.length-1; i>0;--i){
      x[i] = (char)((n%10)+'0');
                   System.out.println(x[i]);
  
      n = n/10;}
       return x;}
    else{