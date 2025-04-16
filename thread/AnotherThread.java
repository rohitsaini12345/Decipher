class AnotherThread extends Thread{
public void run(){
for(int i=10;i>=1;i--)
  try{
	System.out.println(i);
	Thread.sleep(2000);
}
catch(Exception e){}
}


}