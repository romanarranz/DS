package testControlVelocidad;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Reloj;

public class RelojTest extends Thread{
	
	private Reloj r;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# RelojTest");
	}
	
	@Before
	public void testInit(){
		r = new Reloj(new ControlVelocidad());
		err = false;
	}
	
	@Test
	public void testTiempo(){
		System.out.print("\ttestTiempo...");
		try {
			assertTrue(r.getTiempoTranscurrido() == 0);
			
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
