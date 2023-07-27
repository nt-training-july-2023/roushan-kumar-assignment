package ques2;

public class Thread1 extends Thread {
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			
			try {
				System.out.println("thread1");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
