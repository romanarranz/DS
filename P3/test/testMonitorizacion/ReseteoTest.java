package testMonitorizacion;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Eje;
import monitorizacion.CalculadorVelMed;
import monitorizacion.Reseteo;

public class ReseteoTest {
	
	private Reseteo r;
	private CalculadorVelMed c;
	private Eje e;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# ReseteoTest");
	}
	
	@Before
	public void testInit(){
		e = new Eje();
		c = new CalculadorVelMed();
		r = new Reseteo();
		err = false;
	}
	
	@Test
	public void testReset(){
		
		System.out.print("\ttestReset...");
		try {
			assertEquals(e.leerRevoluciones(), 0);
			assert(c.getSumatoriaGas() == 0.0);
			assertEquals(c.getTiempoGas(), 1);
			assertEquals(c.getTiempoVel(), 1);
			
			// cambiamos los valores y comprobamos
			e.velAnterior = 20;
			e.incrementarVueltas(300);
			c.calcularVelocidadMedia(e);
			assertEquals(c.getTiempoVel(), 2);
			assert(c.leerVelMedia() == 20);
			
			// reseteamo los valores y comprobamos
			r.inicializarValores(c, e);
			assertEquals(e.leerRevolucionesTotales(), 0);
			assert(c.getSumatoriaGas() == 0.0);
			assertEquals(c.getTiempoGas(), 1);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
