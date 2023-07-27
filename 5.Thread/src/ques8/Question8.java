package ques8;


public class Question8 {
	public static void main(String[] args) {
		Bank obj = new Bank(20, "Roushan",123456);
		
		System.out.println("Name       : "+obj.getName());
		System.out.println("Amount     : "+obj.getAmount());
		System.out.println("Account No : "+obj.getAccountNo());
		//System.out.println("withdrawal : " + obj.withdrawal( 2,123456) +" Rs" );
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		 new Thread() {
			public void run()
			{
				for(int i=1;i<10;i++) {
					
					System.out.println("withdrawal : " + obj.withdrawal( 20,123456) +" Rs" );
					System.out.println();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				for(int i=1;i<=5;i++) {
				obj.deposit(20);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				}
			}
		}.start();
		
		
		
	}
}
