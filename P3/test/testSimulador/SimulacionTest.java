package testSimulador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simulador.Interfaz;
import simulador.PanelBotones;
import simulador.PanelEtiquetas;
import simulador.Simulacion;

public class SimulacionTest extends Thread {
	private Interfaz i;
	private Simulacion s;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# InterfazTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		s = i.getSimulacion();
		err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(s);
			assertTrue(s instanceof Simulacion);		
			assertEquals(s.getClass().getSuperclass().getSimpleName(), "ListaObservadoresObservables");
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testCrono(){
		System.out.print("\ttestCrono...");
		try {
			
			int t = s.getTiempoTranscurrido();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				err = true;
			}
			assertTrue(t < s.getTiempoTranscurrido());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
			
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testPaneles(){
		System.out.print("\ttestPaneles...");
		try {
			assertTrue(s.getPanelBotones() instanceof PanelBotones);
			assertTrue(s.getPanelEtiquetas() instanceof PanelEtiquetas);
			assertNotSame(s.getPanelBotones(), s.getPanelEtiquetas());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
			
		if(!err) System.out.print("\tok\n");
	}
}
