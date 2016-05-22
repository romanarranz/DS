package testSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public final class allTest {
	public static void main(String[] args) {
		System.out.println("************ TEST CONTROLVELOCIDAD ************");
	    Result result = JUnitCore.runClasses(
	    	testControlVelocidad.PedalTest.class,
	    	testControlVelocidad.PalancaTest.class,
	    	testControlVelocidad.MotorTest.class,
	    	testControlVelocidad.EjeTest.class,
	    	testControlVelocidad.AutomaticoTest.class,
	    	testControlVelocidad.RelojTest.class
	    );
	    for (Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
	}
}
