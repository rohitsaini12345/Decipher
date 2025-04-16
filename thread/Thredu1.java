class Thredu1 extends Thread{
	public void run(){
	try{
	for(int i=1;i<=10;i++){
	   for(int j=1;j<=i;j++){
		System.out.print(i);
	  }
		System.out.println();
	 }
		Thread.sleep(2000);
	}
	catch(Exception e){}
	}

}