package testControlVelocidad;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Reloj;
import simulador.Interfaz;

public class RelojTest extends Thread{
	private Interfaz i;
	private Reloj r1, r2;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# RelojTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		r1 = i.getSimulacion().getPanelBotones().getControlVelocidad().getReloj();
		r2 = i.getSimulacion().getPanelEtiquetas().getControlVelocidad().getReloj();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			// Se ha creado de forma exitosa el reloj en el panelBotones
			assertNotNull(r1);
			assertTrue(r1.getTiempoTranscurrido() == 0);
			assertTrue(r1 instanceof Reloj);
			
			// comprobamos que los relojes tienen la misma referencia en memoria
			assertSame(r1, r2);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testTiempo(){
		System.out.print("\ttestTiempo...");
		try {
				
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			r1.terminate();
			assertTrue(r1.getTiempoTranscurrido() > 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
