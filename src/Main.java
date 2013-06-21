public class Main {
  
/**
   * @param args
   */

  public static void main(String[] args) {
    Counter counter = new Counter();
    counter.count();
    System.out.println("We have counted " 
        + counter.getResult());
    
    Counter counter3 = null;
    try{
        System.out.println("we have counted 3 "+ counter3.getResult());
    }catch(Exception e){
        
    }
    Counter counter2 = counter;
    System.out.println("we have counted 2 "+ counter2.getResult());
   
    
  }
} 