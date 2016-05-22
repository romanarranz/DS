package testControlVelocidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Almacenamiento;
import controlVelocidad.CalculadorVel;

public class CalculadorVelTest {
	private CalculadorVel c;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# CalculadorVelTest");
	}
	
	@Before
	public void testInit(){
		c = new CalculadorVel();
		err = false;
	}
	
	@Test
	public void testVelocidad(){
		System.out.print("\ttestVelocidad...");
		try {
			assertTrue(c.calcularVelocidad(200, 0.8, new Almacenamiento()) > 0.00001);
			assertFalse(c.calcularVelocidad(18, 0.8, new Almacenamiento()) < 0);
			assertEquals(c.calcularVelocidad(40, 1, new Almacenamiento()), 1);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
