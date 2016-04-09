package example;

public class Number {
	private static String type = "decimal";
	private static Number INSTANCE;
	
	protected int value;	
	protected Number(){
		System.out.printf("constructor: ");		
	}
	
	public static Number getInstance(){
		if(INSTANCE == null){
			if(type == "octal")
				INSTANCE = new Octal();
			else
				INSTANCE = new Number();
		}
			
		return INSTANCE;
	}
	
	public static void setType(String t){
		type = t;
		INSTANCE = null;
	}
	
	public void setValue(int in){
		value = in;
	}
	
	public int getValue(){
		return value;
	}
}
