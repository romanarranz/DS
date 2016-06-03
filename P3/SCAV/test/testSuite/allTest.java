package testSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public final class allTest {
	public static void main(String[] args) {
		System.out.println("************ TEST CONTROLVELOCIDAD ************");
	    Result result = JUnitCore.runClasses(
	    	testControlVelocidad.AutomaticoTest.class,
	    	testControlVelocidad.CalculadorVelTest.class,
	    	testControlVelocidad.ControlVelocidadTest.class,
	    	testControlVelocidad.EjeTest.class,
	    	testControlVelocidad.MotorTest.class,
	    	testControlVelocidad.PalancaTest.class,
	    	testControlVelocidad.PedalTest.class,
	    	testControlVelocidad.RelojTest.class
	    );
	    for (Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
	    
	    System.out.println("************ TEST MONITORIZACION ************");
	    result = JUnitCore.runClasses(
	    	testMonitorizacion.CalculadorVelMedTest.class,
	    	testMonitorizacion.DepositoTest.class,
	    	testMonitorizacion.MonitorizacionTest.class,
	    	testMonitorizacion.NotificacionesTest.class,
	    	testMonitorizacion.RelojMTest.class,
	    	testMonitorizacion.ReseteoTest.class
	    );
	    for (Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
	    
	    System.out.println("************ TEST SIMULADOR ************");
	    result = JUnitCore.runClasses(
	    	testSimulador.InterfazTest.class,
	    	testSimulador.ListaObservadoresObservablesTest.class,
	    	testSimulador.PanelBotonesTest.class,
	    	testSimulador.SimulacionTest.class
	    );
	    for (Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
	    
	    System.exit(0);
	}
}
