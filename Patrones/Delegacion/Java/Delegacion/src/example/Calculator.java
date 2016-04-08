package example;

//changing the implementing object in run-time (normally done in compile time)

//the "delegator"
public class Calculator implements CalculationInterface {
	CalculationInterface ci = null;	
	
	// delegation
	public Calculator(CalculationInterface ci){
		this.setI(ci);
	}
	
	// calls the delegate
	public int add(int a, int b){
		return ci.add(a, b);
	}
	
	public int mul(int a, int b){
		return ci.mul(a, b);
	}
	
	public float div(int a, int b){
		return ci.div(a, b);
	}
	
	public int sub(int a, int b){
		return ci.sub(a, b);
	}
	
	// assign the delegate 
	public void setI(CalculationInterface i){
		this.ci = i;
	}
}
