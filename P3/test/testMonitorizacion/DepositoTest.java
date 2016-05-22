package testMonitorizacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Eje;
import monitorizacion.Deposito;

public class DepositoTest {
	
	private Deposito d;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# DepositoTest");
	}
	
	@Before
	public void testInit(){
		d = new Deposito();
		err = false;
	}
	
	@Test
	public void testNiveles(){
		
		System.out.print("\ttestNiveles...");
		try {
			assertTrue(d.leerNivelInicial() > 0);
			assertTrue(d.leerNivelActual() == d.leerNivelInicial());
			
			// actualizamos el deposito incrementando las revoluciones para que disminuya el nivel
			Eje e = new Eje();
			e.incrementarVueltas(300);
			d.actualizarDeposito(e);
		
			assert(d.leerNivelInicial() > d.leerNivelActual());
			assertFalse(d.leerNivelActual() > 100);
			
			d.cambiarANivelInicial();
			assert(d.leerNivelActual() == d.leerNivelInicial());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
