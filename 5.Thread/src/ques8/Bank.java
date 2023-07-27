package ques8;

public class Bank {
	 
	 private int amount=0;
	 private String Name="";
	 private int accountNo;
	 
	 
	
	 public Bank(int amount, String name, int accountNo) {
		super();
		this.amount = amount;
		Name = name;
		this.accountNo = accountNo;
	}

	 synchronized public void deposit(int amount)
	 {
		 System.out.println("\nUpdating Balance " + amount);
		 this.amount+=amount;
		 System.out.println("Updating Complete ava balance "+this.amount);
		 notify();
	 }
	 
	 synchronized public int withdrawal(int amount,int accountNo)
	 {
		 
		 try {
			 if(this.accountNo==accountNo)
			 {
				 if(this.amount>=amount)
				 {
					 this.amount-=amount;
					 System.out.println(amount+" rs is debited from Account No "+this.accountNo );
					 System.out.println("Available Balance :"+this.amount );
					 return amount;
				 }
				 else
				 {
					 System.out.println("Insufficent Balance to make transaction!");
					 try {
						 wait(2000);
						 return 0;
					 }catch (InterruptedException ie) {
						System.out.println(ie.getStackTrace());
					}
				 }
			 }
			 else
			 {
				 System.out.println("Account No Invalid");
			 }
		 }
		 catch (Exception e) {
			
		}
		 
		 return 0;
	 }

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	 
	 
}
