package example;

public class StackFIFO extends Stack {
    
	private StackImpl temp = new StackList();
    
    public StackFIFO() {
        super( "array" );
    }
    
    public StackFIFO( String s ) {
        super( s );
    }
    
    public int pop() {
        while ( ! isEmpty()) {
            temp.push( super.pop() );
        }
        int ret =  temp.pop();
        while ( ! temp.isEmpty()) {
            push( temp.pop() );
        }
        return ret;
    }
}
