import java.lang.*;  
  
public class ThreadPriority extends Thread   
{  
   
public void run()  
{    
System.out.println("Inside the run() method");  
}  
   
public static void main(String args[])  
{   
ThreadPriority th1 = new ThreadPriority();  
ThreadPriority th2 = new ThreadPriority();  
ThreadPriority th3 = new ThreadPriority();  
  
//we cannot give priority so it will take a default value

System.out.println("Priority of the thread th1 is : " + th1.getPriority());  
   
System.out.println("Priority of the thread th2 is : " + th2.getPriority());  
  

System.out.println("Priority of the thread th2 is : " + th3.getPriority());  
  
//there priority is given
 
th1.setPriority(6);  
th2.setPriority(3);  
th3.setPriority(9);  
   
System.out.println("Priority of the thread th1 is : " + th1.getPriority());  
    
System.out.println("Priority of the thread th2 is : " + th2.getPriority());  
  
System.out.println("Priority of the thread th3 is : " + th3.getPriority());   
  
// Displaying name of the currently executing thread   
System.out.println("Currently Executing The Thread : " + Thread.currentThread().getName());  
  
System.out.println("Priority of the main thread is : " + Thread.currentThread().getPriority());  
  
Thread.currentThread().setPriority(10);  
  
System.out.println("Priority of the main thread is : " + Thread.currentThread().getPriority());  
}  
}    