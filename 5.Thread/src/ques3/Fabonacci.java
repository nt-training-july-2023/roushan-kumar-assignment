package ques3;

public class Fabonacci extends Thread {
	
	int a=0;
	int b=1;
	int n=10;
	
	
	
	public Fabonacci(int n) {
		super();
		this.n = n;
	}



	public void run()
	{
		System.out.println(a);
		System.out.println(b);
		while(n>=0) {
			int c;
			
			try {
				c=a;
				a=b;
				b=c+b;
				System.out.println(b);
				n--;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
