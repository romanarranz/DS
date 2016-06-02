package testMonitorizacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monitorizacion.Monitorizacion;
import monitorizacion.RelojM;
import simulador.Interfaz;

public class RelojMTest extends Thread {

	private Interfaz i;
	private Monitorizacion m;
	private RelojM r;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# RelojMTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		m = i.getSimulacion().getPanelBotones().getMonitorizacion();
		r = m.getReloj();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(r);
			assertTrue(r instanceof RelojM);
			assertSame(r, i.getSimulacion().getPanelEtiquetas().getMonitorizacion().getReloj());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testCrono(){
		
		System.out.print("\ttestCrono...");
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			r.terminate();
			
			assertTrue(r.getTiempoTranscurrido() > 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
