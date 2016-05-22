package testControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;  

import controlVelocidad.Freno;
import controlVelocidad.Acelerador;

public class PedalTest {

	private Freno f;
	private Acelerador a;
	private boolean err;
	
	// se ejecuta solo una unica vez antes de llamar a cualquier metodo de la clase
	@BeforeClass
	public static void init(){
		System.out.println("# PedalTest");
	}
	
	// se ejecuta por cada metodo que se invoca de forma previa 
	@Before  
    public void testInit(){
		err = false;
		
		f = new Freno();
		a = new Acelerador();		
	}
	
	@Test  
    public void testLeerEstado(){
		
		System.out.print("\ttestLeerEstado...");
		try {
			assertFalse(f.leerEstado() == true);
			assertTrue(a.leerEstado() == false);
			assert(Acelerador.ROZAMIENTO > 0);
			assert(Freno.ROZAMIENTO > 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testActualizarPedal(){
		
		System.out.print("\ttestActializarPedal...");
		
		try {
			assertTrue(a.actualizarAcelerador(50) > 0);
			assertFalse(f.actualizarFreno() < 0);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testVelocidad(){
		
		System.out.print("\ttestVelocidad...");
		try {
			a.soltar();
			assertEquals(a.leerEstado(), false);
			a.pisar();
			assertEquals(a.leerEstado(), true);
			
			
			f.soltar();
			assertEquals(f.leerEstado(), false);
			f.pisar();
			assertEquals(f.leerEstado(), true);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
