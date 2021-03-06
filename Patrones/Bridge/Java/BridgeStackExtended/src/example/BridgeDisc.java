package example;

public class BridgeDisc {
    public static void main( String[] args ) {
        Stack[] stacks = { 
        		new Stack( "array" ),
        		new Stack( "list" ),
                new StackFIFO(),
                new StackHanoi()
        };
        
        for (int i=1; i < 15; i++)
            for (int j=0; j < 3; j++)
                stacks[j].push( i );            
        
        java.util.Random rn = new java.util.Random();
        for (int i=1; i < 15; i++)
            stacks[3].push( rn.nextInt(20) );
        
        for (int i=0; i < stacks.length; i++) {
            while ( ! stacks[i].isEmpty()) {
                System.out.print( stacks[i].pop() + "  " );
            }
            System.out.println();
        }
        System.out.println("total rejected is " + ((StackHanoi)stacks[3]).reportRejected() );
    }
}