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

import monitorizacion.CalculadorVelMed;
import simulador.Interfaz;

public class CalculadorVelMedTest {
	private Interfaz i;
	private CalculadorVelMed cal;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# CalculadorVelMedTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		cal = i.getSimulacion().getPanelBotones().getMonitorizacion().getCalculadorVelMed();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(cal);
			assertTrue(cal instanceof CalculadorVelMed);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testNiveles(){
		
		System.out.print("\ttestVelocidades...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
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
