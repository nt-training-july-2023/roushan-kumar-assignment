package innerClass;



public class TestInnerClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		
		outerClass.display();
		innerClass.display();
		
		//calling outerMethod of outerClass
		outerClass.outerMethod();
		
		innerClass.valueX();
		
		
		OuterClass.staticInnerClass.printV();
		OuterClass.saticOuterMethod();
		
		
	}
}
