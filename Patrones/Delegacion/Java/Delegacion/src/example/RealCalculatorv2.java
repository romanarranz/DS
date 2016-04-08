package example;

//the "delegate"
public class RealCalculatorv2 implements CalculationInterface{

	public int add(int a, int b) {
		return a+b+5;
	}

	public int mul(int a, int b) {
		return a*b*5;
	}

	public float div(int a, int b) {
		return (float) (a/b)/5;
	}
	
	public int sub(int a, int b) {
		return a-b-5;
	}	
}
