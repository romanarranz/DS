package testControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Motor;

public class MotorTest {

	private Motor m;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# MotorTest");
	}
	
	@Before
	public void testInit(){
		m = new Motor();
		err = false;
	}
	
	@Test
	public void testEstado(){
		System.out.print("\ttestEstado...");
		try {
			assertTrue(m.leerEstado() == false);
			
			m.cambiarEstado();
			assertFalse(m.leerEstado() == false);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
