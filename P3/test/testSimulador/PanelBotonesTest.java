package testSimulador;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simulador.Interfaz;
import simulador.PanelBotones;
import simulador.PanelEtiquetas;

public class PanelBotonesTest {

	private Interfaz i;
	private PanelBotones pb;
	private PanelEtiquetas pe;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# PanelBotonesTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		pb = i.getSimulacion().getPanelBotones();
		pe = i.getSimulacion().getPanelEtiquetas();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(pb);
			assertNotNull(pe);
			assertTrue(pb instanceof PanelBotones);		
			assertTrue(pe instanceof PanelEtiquetas);
			assertNotSame(pb, pe);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testPaneles(){
		System.out.print("\ttestReferencias...");
		try {
			assertSame(pb.getControlVelocidad(), i.getControlVelocidad());
			assertSame(pb.getMonitorizacion(), i.getMonitorizacion());
			assertSame(pe.getControlVelocidad(), i.getControlVelocidad());
			assertSame(pe.getMonitorizacion(), i.getMonitorizacion());			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
			
		if(!err) System.out.print("\tok\n");
	}
}
