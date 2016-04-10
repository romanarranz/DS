package example;

//Derive the separate implementations from the common abstraction
public class StackMine implements StackImp {
	
	private Object[] items = new Object[20];
	private int total = -1;

	public Object push( Object o ) {
		return items[++total] = o;
	}
	
	public Object peek() {
		return items[total];
	} 
	
	public Object pop() {
	    return items[total--];
	}
	
	public boolean empty() {
	    return total == -1;
	}
}