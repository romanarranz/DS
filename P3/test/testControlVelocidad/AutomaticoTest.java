package testControlVelocidad;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Automatico;

public class AutomaticoTest {

	private Automatico a;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# AutomaticoTest");
	}
	
	@Before
	public void testInit(){
		a = new Automatico();
		err = false;
	}
	
	@Test
	public void testRevoluciones(){
		
		System.out.print("\ttestRevoluciones...");
		try {
			System.out.print("\nPREGUNTAR AL PROFESOR POR SI TENEMOS QUE RESOLVER DEPENDENCIAS DE CLASES");
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
