package example;

public class SingletonExample {

	public static void main(String[] args) {
		Number.getInstance().setValue(42);
		System.out.printf("value is "+Number.getInstance().getValue()+"\n");
		
		Number.getInstance().setType("octal");
		Number.getInstance().setValue(64);
		System.out.printf("value is "+Number.getInstance().getValue()+"\n");
	}
}
