package testControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Eje;
import simulador.Interfaz;

public class EjeTest {

	private Interfaz i;
	private ControlVelocidad c;
	private Eje e;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# EjeTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		e = c.getEje();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(e);
			assertTrue(e instanceof Eje);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testRevoluciones(){
		
		System.out.print("\ttestRevoluciones...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(c.getMotor().leerEstado() == true);
			assertTrue(e.leerRevoluciones() == 0);
			assertTrue(e.leerRevolucionesTotales() == 0);
			
			// acelerar
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			assertEquals(c.getAcelerador().leerEstado(), true);			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			assertTrue(e.leerRevoluciones() > 0);						

			// frenando el motor
			int revoluciones = c.obtenerRev();
			i.getSimulacion().getPanelBotones().toggleFreno();
			i.getSimulacion().getPanelBotones().BotonFrenoActionPerformed(ae);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			// si las rev de antes son mayores a las de ahora, es porque estamos frenando
			assertTrue(revoluciones > e.leerRevoluciones());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
