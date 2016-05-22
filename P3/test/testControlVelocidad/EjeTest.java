package testControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Eje;

public class EjeTest {

	private Eje e;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# EjeTest");
	}
	
	@Before
	public void testInit(){
		e = new Eje();
		err = false;
	}
	
	@Test
	public void testRevoluciones(){
		
		System.out.print("\ttestRevoluciones...");
		try {
			assertTrue(e.MAXVUELTAS > 0);
			assert(e.RADIO > 0 && e.RADIO < 1);
			assertTrue(e.leerRevolucionesTotales() == 0);
			
			e.incrementarVueltas(10);
			assertEquals(e.leerRevoluciones(), 10);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
