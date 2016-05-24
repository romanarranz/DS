package testMonitorizacion;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monitorizacion.Notificaciones;

public class NotificacionesTest {
	
	private Notificaciones n;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# NotificacionesTest");
	}
	
	@Before
	public void testInit(){
		n = new Notificaciones();
		err = false;
	}
	
	@Test
	public void testActualiza(){
		
		System.out.print("\ttestActualiza...");
		try {
			long aceite = n.leerRevolAceite();
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
