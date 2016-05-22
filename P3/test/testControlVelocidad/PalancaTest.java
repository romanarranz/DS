package testControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Palanca;

public class PalancaTest {
	
	private Palanca p;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# PalancaTest");
	}
	
	@Before
	public void testInit(){
		p = new Palanca();
		err = false;
	}
	
	@Test
	public void testEstado(){
		System.out.print("\ttestEstado...");
		try {
			assertFalse(p.leerEstado() > 2);
			assertTrue(p.leerEstado() <= 2);
			
			p.cambiarEstado(1);
			assertEquals(p.leerEstado(), 1);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
