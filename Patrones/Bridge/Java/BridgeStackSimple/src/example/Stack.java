package example;

//Create an interface/wrapper class that "has a"
//implementation object and delegates all requests to it
public class Stack {
	
	protected StackImp imp;
	
	public Stack( String s ) { 
		if (s.equals("java")) {
			imp = new StackJava();
	    }
	    else {
	    	imp = new StackMine();
	    }
	}
	
	public Stack() {
		this( "java" );
	}
	
	public void push( int in ) {
		imp.push( new Integer(in) );
	}
	
	public int pop() {
		return ((Integer)imp.pop()).intValue();
	}
	
	public boolean isEmpty() {
		return imp.empty();
	}
}
