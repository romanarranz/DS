package testControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Motor;
import simulador.Interfaz;

public class MotorTest {
	
	private Interfaz i;
	private Motor m;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# MotorTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		m = i.getSimulacion().getPanelBotones().getControlVelocidad().getMotor();
		err = false;
	}	

	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			// Se ha creado de forma exitosa el calculadorVelocidad
			assertNotNull(m);
			assertTrue(m instanceof Motor);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testEstado(){
		System.out.print("\ttestEstado...");
		try {
			// motor apagado al comienzo
			assertTrue(m.leerEstado() == false);
			
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
		
			// motor en marcha cuando lo encendemos
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(m.leerEstado() == true);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;			
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
