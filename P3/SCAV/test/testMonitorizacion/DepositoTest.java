package testMonitorizacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monitorizacion.Deposito;
import simulador.Interfaz;

public class DepositoTest {
	
	private Interfaz i;
	private Deposito d;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# DepositoTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		d = i.getSimulacion().getPanelBotones().getMonitorizacion().getDeposito();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(d);
			assertTrue(d instanceof Deposito);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testNiveles(){
		
		System.out.print("\ttestNiveles...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(d.leerNivelInicial() > 0);
			assertTrue(d.leerNivelActual() == d.leerNivelInicial());
			
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
			
			// Paramos motor y repostamos gasolina para rellenar el deposito
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			i.getSimulacion().getPanelBotones().BotonRepostarActionPerformed(ae);
			
			assertTrue(d.leerNivelActual() == d.leerNivelInicial());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
