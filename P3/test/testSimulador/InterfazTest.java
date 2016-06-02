package testSimulador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simulador.Interfaz;

public class InterfazTest {
	
	private Interfaz i;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# InterfazTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(i);
			assertTrue(i instanceof Interfaz);		
			assertEquals(i.getClass().getSuperclass().getSimpleName(), "JApplet");
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testGeneral(){
		System.out.print("\ttestGeneral...");
		try {
			assertNotNull(i.getMonitorizacion());
			assertNotNull(i.getSimulacion());
			assertNotNull(i.getControlVelocidad());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
			
		if(!err) System.out.print("\tok\n");
	}
}
