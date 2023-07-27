package ques2;

public class Thread2 extends Thread {
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			
			try {
				System.out.println("Thread2");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
