public class TestDaemon extends Thread{  
 public void run(){  
  if(Thread.currentThread().isDaemon()){        //checking for daemon thread  
   System.out.println("Daemon thread work");  
  }  
  else{  
  System.out.println("Not Daemon thread work");  
 }  
 }  
 public static void main(String[] args){
  //creating thread  
  TestDaemon t1=new TestDaemon(); 
  TestDaemon t2=new TestDaemon();  
  TestDaemon t3=new TestDaemon();  
  
  t1.setDaemon(true);     // t1 is daemon thread  
    
  t1.start(); 
  t2.start();  
  t3.start();  
 }  
}  