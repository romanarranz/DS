package example;

public class Octal extends Number{
	protected Octal(){}
	
	public void setValue(int in){
	  	value = Integer.parseInt(Integer.toOctalString(in));
	}
}
