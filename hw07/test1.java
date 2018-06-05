public class test1{
  public static void main(String [] args) {
    String a ="a";
    String c = "c";
    int x = a.compareTo("b");
    int y = c.compareTo("b");
    System.out.println(x+" "+y
   public String ceiling(String var)  {

     if(contains(var)){
       return var;
     }
     else{
       return ceilingHelper(var,head);
     }
   }
          
  private String ceilingHelper(String var, Node p){
  Node q = p.next;
  if(p.variable.compareTo(var)>q.variable.compareTo(var)){
    return floorHelper(var,p.next);
  }
     else{
       return q.variable;
     }
     }
  );
  }}


 public String floor(String var) throws KeyNotFoundException {
          String str = head.variable;
          if(isEmpty()){
             throw new KeyNotFoundException("nope! ")  ;
          }
          if(str.compareTo(var)>0){
            throw new KeyNotFoundException("nope! ")  ;
          }
          if (contains(var)){
            return var;
          }
          else{
            return  floorHelper(var,head);
          }
          
        }     
          

    