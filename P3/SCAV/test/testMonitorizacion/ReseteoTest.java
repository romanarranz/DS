package testMonitorizacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;
import monitorizacion.CalculadorVelMed;
import monitorizacion.Monitorizacion;
import monitorizacion.Reseteo;
import simulador.Interfaz;

public class ReseteoTest extends Thread {
	
	private Interfaz i;
	private Monitorizacion m;
	private ControlVelocidad c;
	private Reseteo r;
	private CalculadorVelMed cal;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# ReseteoTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();		
		m = i.getSimulacion().getPanelBotones().getMonitorizacion();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		cal = m.getCalculadorVelMed();
		r = m.getReseteo();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(r);
			assertTrue(r instanceof Reseteo);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testReset(){
		
		System.out.print("\ttestReset...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertEquals(c.obtenerRev(), 0);
			assertTrue(cal.getSumatoriaGas() == 0.0);
			assertEquals(cal.getTiempoGas(), 1);
			assertEquals(cal.getTiempoVel(), 1);
			
			// Acelerador: pulso boton
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);			
			
			int tVel = cal.getTiempoVel();
			double velMedia = cal.leerVelMedia();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			
			// cambiamos los valores y comprobamos
			assertTrue(tVel < cal.getTiempoVel());
			assertTrue(velMedia < cal.leerVelMedia());

			// reseteamo los valores y comprobamos
			i.getSimulacion().getPanelBotones().BotonRestearActionPerformed(ae);			
			assertEquals(c.obtenerRevtotal(), 0);
			assertTrue(cal.getSumatoriaGas() == 0.0);
			assertEquals(cal.getTiempoGas(), 1);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
