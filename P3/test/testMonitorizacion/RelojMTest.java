package testMonitorizacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Eje;
import monitorizacion.Monitorizacion;
import monitorizacion.RelojM;

public class RelojMTest extends Thread {

	private RelojM r;
	private Eje e;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# RelojMTest");
	}
	
	@Before
	public void testInit(){
		e = new Eje();
		r = new RelojM(new Monitorizacion(e));
		err = false;
	}
	
	@Test
	public void testCrono(){
		
		System.out.print("\ttestCrono...");
		try {
			assertEquals(r.getTiempoTranscurrido(), 0);			
			r.start();
			
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
