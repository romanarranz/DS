package testMonitorizacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monitorizacion.Monitorizacion;
import monitorizacion.Notificaciones;
import simulador.Interfaz;

public class NotificacionesTest {
	
	private Interfaz i;
	private Monitorizacion m;
	private Notificaciones n;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# NotificacionesTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		m = i.getSimulacion().getPanelBotones().getMonitorizacion();
		n = m.getNotificaciones();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(n);
			assertTrue(n instanceof Notificaciones);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testActualiza(){
		
		System.out.print("\ttestActualiza...");
		try {
			
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			long aceite = n.leerRevolAceite();
			long pastillas = n.leerRevolPastillas();
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertEquals(aceite, 0);
			assertEquals(pastillas, 0);
			
			// Acelerador: pulso boton
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);			
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			
			assertTrue(aceite < n.leerRevolAceite());
			assertTrue(pastillas < n.leerRevolPastillas());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testNotifica(){
		
		System.out.print("\ttestNotifica...");
		try {
			
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			boolean aceite = n.notificarAceite();
			boolean pastillas = n.notificarPastillas();
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(aceite == false);
			assertTrue(pastillas == false);
			
			// Como tardaria mucho tiempo en realizar el cambio, lo voy a provocar a mano
			n.setRevolPastillas(1000000);
			
			pastillas = n.notificarPastillas(); 
			assertTrue(pastillas == true);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
