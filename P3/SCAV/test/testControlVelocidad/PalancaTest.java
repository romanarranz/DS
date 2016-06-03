package testControlVelocidad;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Palanca;
import simulador.Interfaz;

public class PalancaTest {
	
	private Interfaz i;
	private ControlVelocidad c;
	private Palanca p;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# PalancaTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		c = i.getSimulacion().getPanelBotones().getControlVelocidad();
		p = c.getPalanca();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(p);
			assertTrue(p instanceof Palanca);			
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
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			assertTrue(p.leerEstado() == Palanca.APAGADO);
			
			i.getSimulacion().getPanelBotones().BotonMantenerActionPerformed(ae);
			assertTrue(c.getPalanca().leerEstado() == Palanca.MANTENIENDO);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}