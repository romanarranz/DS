package testControlVelocidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;;

public class ControlVelocidadTest extends Thread {
	private ControlVelocidad c;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# ControlVelocidadTest");
	}
	
	@Before
	public void testInit(){
		c = new ControlVelocidad();
		err = false;
	}
	
	@Test
	public void testAlmacenaje(){
		System.out.print("\ttestAlmacenaje...");
		try {
			c.motor.cambiarEstado();
			c.freno.soltar();
			
			c.acelera.pisar();
			c.eje.velAnterior = 20;	
			c.acelera.incrementar(20, c.eje);
			c.acelera.actualizarAcelerador(10);
			
			c.almacena.almacenarVelocidad(20);
			c.almacena.almacenarVelSeleccionada();
			
			c.controlarEstado();
			
			assertFalse(c.obtenerDist() < -100);
			assertTrue(c.obtenerDist() >= 0);
			assertFalse(c.obtenerVel() > 10);
			assertEquals(c.obtenerVel(), 5);
			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testEjes(){
		
		System.out.print("\ttestEjes...");
		try {
			// encendiendo el motor
			c.motor.cambiarEstado();
			c.freno.soltar();
			
			c.acelera.pisar();
			c.eje.velAnterior = 20;			
			c.acelera.incrementar(20, c.eje);
			c.acelera.actualizarAcelerador(10);
			
			c.eje.calcularVelocidad(c.almacena);
			c.eje.incrementarVueltas(3);
			c.eje.calcularVelocidad(c.almacena);
			
			c.controlarEstado();
			
			assertTrue(c.obtenerRev() > 0);
			assertTrue(c.obtenerRevtotal() > 0);
			
			// mantiene
			int revBefore = c.obtenerRev();
			long revTotalBefore = c.obtenerRevtotal();
			c.cambiarPalanca(1);
			c.controlarEstado();
			
			assert(revBefore == c.obtenerRev());
			assert(revTotalBefore == c.obtenerRevtotal());
			
			// apagando el motor
			c.motor.cambiarEstado();
			c.controlarEstado();
			
			assertEquals(c.obtenerRev(), 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
