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
import monitorizacion.Deposito;
import monitorizacion.Monitorizacion;
import monitorizacion.Notificaciones;
import monitorizacion.RelojM;
import simulador.Interfaz;

public class MonitorizacionTest {
	private Interfaz i;
	private Monitorizacion m;
	private Deposito d;
	private CalculadorVelMed cal;
	private RelojM r;
	private Notificaciones n;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# MonitorizacionTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		m = i.getSimulacion().getPanelBotones().getMonitorizacion();
		d = m.getDeposito();
		cal = m.getCalculadorVelMed();
		r = m.getReloj();
		n = m.getNotificaciones();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(m);
			assertTrue(m instanceof Monitorizacion);			
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
			
			// encender
			long aceite = n.leerRevolAceite();
			long pastillas = n.leerRevolPastillas();
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(d.leerNivelInicial() > 0);
			assertTrue(d.leerNivelActual() == d.leerNivelInicial());
			assertEquals(aceite, 0);
			assertEquals(pastillas, 0);
			
			// Acelerador: pulso boton
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);			
						
			double nivel = d.leerNivelActual();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			assertTrue(d.leerNivelInicial() > d.leerNivelActual());
			assertTrue(d.leerNivelActual() < nivel);
			assertTrue(r.getTiempoTranscurrido() > 0);
			assertTrue(aceite < n.leerRevolAceite());
			assertTrue(pastillas < n.leerRevolPastillas());
			
			// Paramos motor y repostamos gasolina para rellenar el deposito
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			i.getSimulacion().getPanelBotones().BotonRepostarActionPerformed(ae);
			
			assertTrue(d.leerNivelActual() == d.leerNivelInicial());
			
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
	
	@Test
	public void testVelocidades(){
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
