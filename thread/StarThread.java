import java.util.*;
class StarThread implements Runnable{
  public void run(){
	for(int i=1;i<=10;i++){
		System.out.println(i);
	   try{
		
		Thread.sleep(1000);
		}
	   catch(Exception e){
		}
	}
}
public static void main(String[] args){
	StarThread s=new StarThread();
        Thread t=new Thread(s);

        StarThread2 s1 = new StarThread2();
        
	t.start();
        s1.start();

	}
}