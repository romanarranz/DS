package testControlVelocidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;
import simulador.Interfaz;

public class ControlVelocidadTest extends Thread {
	
	private Interfaz i;
	private ControlVelocidad c;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# ControlVelocidadTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(c);
			assertTrue(c instanceof ControlVelocidad);
			assertSame(c, i.getSimulacion().getPanelEtiquetas().getControlVelocidad());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testAlmacenaje(){
		System.out.print("\ttestAlmacenaje...");
		try {			
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(c.getMotor().leerEstado() == true);
			assertTrue(c.obtenerDist() == 0);
			
			// acelerar
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			assertEquals(c.getAcelerador().leerEstado(), true);			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			assertTrue(c.obtenerVel() > 0);
			assertTrue(c.obtenerDist() > 0);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testGeneral(){
		
		System.out.print("\ttestGeneral...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(c.getMotor().leerEstado() == true);
			
			// acelerar
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			assertEquals(c.getAcelerador().leerEstado(), true);			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			assertTrue(c.leerVelocidad() > 0);			
			
			// mantener velocidad
			i.getSimulacion().getPanelBotones().BotonMantenerActionPerformed(ae);
						
			int revoluciones = c.obtenerRev();						
			try { 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}			
			assertEquals(revoluciones, c.obtenerRev());
			
			// apagando el motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);			
			assertTrue(c.getMotor().leerEstado() == false);
			revoluciones = c.obtenerRev();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			
			// si las rev de antes son mayores a las de ahora, esta parando progresivamente
			assertTrue(revoluciones > c.obtenerRev());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
