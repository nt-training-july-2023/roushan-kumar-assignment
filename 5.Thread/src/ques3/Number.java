package ques3;

public class Number implements Runnable {

	
	int n;
	
	
	
	public Number(int n) {
		super();
		this.n = n;
	}

	@Override
	public void run() {
		
		for(int i=1;i<=n;i++)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Number : "+i);
		}
		
	}

}
