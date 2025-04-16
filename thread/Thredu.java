import java.util.*;
//package thread;
class StarThread implements Runnable{
  public void run(){
	for(int i=1;i<=10;i++){
	    for(int j=1;j<=i;j++){
		System.out.print("*");
		}
		System.out.println();
	
	   try{
		
		Thread.sleep(1000);
		}
	   catch(Exception e){
		}
	}
    }
 
}
class Thredu{
public static void main(String[] args){
	StarThread s=new StarThread();
        Thread t=new Thread(s);

        Thredu1 t1=new Thredu1();
        
	t.start();
	t1.start();
      

	}
}