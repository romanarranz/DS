package example;

public class DelegationExample {

	public static void main(String[] args) {
		
		Calculator c = new Calculator(new RealCalculator());
		System.out.println(c.add(10, 20));
		System.out.println(c.mul(2, 3));
		
		c.setI(new RealCalculatorv2());
		System.out.println(c.add(10, 20));
		System.out.println(c.mul(2, 3));		
	}
}
