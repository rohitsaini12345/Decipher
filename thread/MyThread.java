class MyThread implements Runnable{
 public void run(){
   for(int i=1;i<=10;i++){
     try{
	System.out.println("value of i: "+i);
	Thread.sleep(1000);
	}
	catch(Exception e){
}
     
}
}
public static void main(String[] args){
 MyThread t1=new MyThread();
 Thread th=new Thread(t1);
 AnotherThread t2=new AnotherThread();
 th.start(); 
 t2.start();
}
}