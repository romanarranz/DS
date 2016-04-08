package example;

//the "delegate"
public class RealCalculator implements CalculationInterface {
	
	public int add(int a, int b){
		return a+b;
	}
	
	public int mul(int a, int b){
		return a*b;
	}
	
	public float div(int a, int b){
		return (float) (a/b);
	}
	
	public int sub(int a, int b){
		return a-b;
	}
}
