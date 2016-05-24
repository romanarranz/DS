package testControlVelocidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.CalculadorVel;
import controlVelocidad.ControlVelocidad;
import simulador.Interfaz;

public class CalculadorVelTest {
	private Interfaz i;
	private ControlVelocidad c;
	private CalculadorVel cal;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# CalculadorVelTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		cal = i.getSimulacion().getPanelBotones().getControlVelocidad().getEje().getCalculadorVel();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			// Se ha creado de forma exitosa el calculadorVelocidad
			assertNotNull(cal);
			assertNotNull(c);
			assertTrue(cal instanceof CalculadorVel);
			assertTrue(c instanceof ControlVelocidad);			
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
			assertEquals(new Long(0), new Long(c.obtenerRevtotal()));
			assertEquals(new Integer(4), new Integer(cal.calcularVelocidad(180, 1, c.getAlmacen())));
			assertEquals(new Integer(0), new Integer(c.leerVelSeleccionada()));
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
