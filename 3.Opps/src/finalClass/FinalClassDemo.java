package finalClass;


final class IciciBank{
	
	final String name="ICICI BANK";
	final float interest = 4.5f;
	
	public void name() {
		System.out.println("Name "+name);
	}
	public void interest() {
		System.out.println("Interest "+interest);
	}
}

//Final classes cannot be extended or inherited.
//class A extends IciciBank
//{
//	
//}




public class FinalClassDemo {

	public static void main(String[] args) {
		IciciBank iciciBank = new IciciBank();
		
		iciciBank.name();
		iciciBank.interest();
		
	}
	
}
