package ques2;



class User{
	int accountNo;
	int amount;
	public User(int accountNo, int amount) {
		super();
		this.accountNo = accountNo;
		this.amount = amount;
	}
	
	public User() {
		
	}

	public void withdrawal() throws InvalidInputException
	{
		if(amount<0 )
		{
			throw new InvalidInputException("Amount not less then zero");
		}
		else if(amount != (int )amount)
		{
			throw new InvalidInputException("Amount not non-numeric ");
		}
		else if(accountNo<0)
		{
			throw new InvalidInputException("Account Number not less then zero");
		}
		else if(accountNo != (int)accountNo)
		{
			throw new InvalidInputException("Amount not non-numeric ");
		}
		else
		{
			System.out.println(amount +"Rs is withdrawal from account Number "+accountNo);
		}
	}
	
}

public class Question2 {
	public static void main(String[] args) throws InvalidInputException {
		User user1  = new User(12345,26);
		try {
			user1.withdrawal();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("User");
		User user2  = new User(-12345, 25);
		try {
			user2.withdrawal();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("User");
	}
}
