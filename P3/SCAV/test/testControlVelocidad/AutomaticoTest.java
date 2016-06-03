package testControlVelocidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Acelerador;
import controlVelocidad.Automatico;
import controlVelocidad.ControlVelocidad;
import simulador.Interfaz;

public class AutomaticoTest extends Thread{

	private Interfaz i;
	private Automatico a;
	private ControlVelocidad c;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# AutomaticoTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		a = c.getAutomatico();		
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			// Se ha creado de forma exitosa el reloj en el panelBotones
			assertNotNull(a);
			assertTrue(a instanceof Automatico);
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
			Acelerador acelerador = i.getSimulacion().getPanelBotones().getControlVelocidad().getAcelerador(); 
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			
			// accionamos Acelerador
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			assertEquals(acelerador.leerEstado(), true);
			
			// seguidamente accionamos automatico para mantener la velocidad
			i.getSimulacion().getPanelBotones().BotonMantenerActionPerformed(ae);
			
			// recupero la velocidad a la que se mantiene el vehiculo, si tras 1 segundo sigue igual quiere decir que 
			// se aplica correctamente
			int revoluciones = c.leerVelSeleccionada();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}			
			assertEquals(revoluciones, c.leerVelSeleccionada());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
