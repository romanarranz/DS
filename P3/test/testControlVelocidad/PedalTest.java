package testControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;  

import controlVelocidad.Freno;
import controlVelocidad.Pedal;
import simulador.Interfaz;
import controlVelocidad.Acelerador;

public class PedalTest {

	private Interfaz i;
	private Pedal acelerador;
	private Pedal freno;
	private boolean err;
	
	// se ejecuta solo una unica vez antes de llamar a cualquier metodo de la clase
	@BeforeClass
	public static void init(){
		System.out.println("# PedalTest");
	}
	
	// se ejecuta por cada metodo que se invoca de forma previa 
	@Before  
    public void testInit(){
		i = new Interfaz();
		acelerador = i.getControlVelocidad().getAcelerador();
		freno = i.getControlVelocidad().getFreno();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			// Se ha creado de forma exitosa el reloj en el panelBotones
			assertNotNull(acelerador);
			assertNotNull(freno);
			assertTrue(acelerador instanceof Acelerador);
			assertTrue(freno instanceof Freno);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test  
    public void testLeerEstado(){
		
		System.out.print("\ttestLeerEstado...");
		try {
			assertFalse(freno.leerEstado() == true);
			assertTrue(acelerador.leerEstado() == false);
			assertTrue(Acelerador.ROZAMIENTO > 0);
			assertTrue(Freno.ROZAMIENTO > 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testActualizarPedal(){
		
		System.out.print("\ttestActualizarPedal...");
		
		try {
			assertTrue(((Acelerador) acelerador).actualizarAcelerador(50) > 0);
			assertFalse(((Freno) freno).actualizarFreno() < 0);			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testVelocidad(){
		
		System.out.print("\ttestVelocidad...");
		try {
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			
			// Acelerador: pulso boton
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			assertEquals(acelerador.leerEstado(), true);
			i.getSimulacion().getPanelBotones().BotonReiniciarActionPerformed(ae);
			assertEquals(acelerador.leerEstado(), false);
			// reestablezco acelerador
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			
			// Freno: pulso boton
			i.getSimulacion().getPanelBotones().toggleFreno();
			i.getSimulacion().getPanelBotones().BotonFrenoActionPerformed(ae);
			assertEquals(freno.leerEstado(), true);
			i.getSimulacion().getPanelBotones().BotonReiniciarActionPerformed(ae);
			assertEquals(freno.leerEstado(), false);
			// reestablezco freno
			i.getSimulacion().getPanelBotones().toggleFreno();
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
