package finalBlankVariable;

class Packet{
	final int capacity;
	
	public Packet(int cap)
	{
		capacity=cap;
	}
	
	public void printCapacity()
	{
		System.out.println("final capacity of this packet is "+capacity);
	}
}

public class FinalBlankVariable {
	public static void main(String[] args) {
		Packet packet = new Packet(5);
		packet.printCapacity();
	}
}
