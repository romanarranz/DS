package testControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlVelocidad.Almacenamiento;
import controlVelocidad.ControlVelocidad;
import controlVelocidad.Palanca;

public class PalancaTest {
	
	private Palanca p;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# PalancaTest");
	}
	
	@Before
	public void testInit(){
		p = new Palanca();
		err = false;
	}
	
	@Test
	public void testEstado(){
		System.out.print("\ttestEstado...");
		try {
			// tendriamos que simular una pulsacion de boton del actionperformed para que cambie el estado
			// interno del singleton y obtener el resultado esperado.
			
			// en resumen tengo que provocar la pulsacion por boton mediante sw.
			assertFalse(p.leerEstado() > 2);
			assertTrue(p.leerEstado() <= 2);
			
			p.cambiarEstado(1);
			assertEquals(p.leerEstado(), 1);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	/*
	 * 
	 * Sugerido por el profesor
	 */
	@Test
	public void testAutomatico(){
		System.out.print("\ttestEstado...");
		ControlVelocidad c = new ControlVelocidad();
		Almacenamiento a = c.getAlmacen();
		try {
			assertTrue(c.getPalanca().leerEstado() == Palanca.APAGADO);
			assertTrue(c.obtenerVel() > 0);
			
			MouseEvent evento = new MouseEvent(new Label(), 0,0,0, false);
			PanelBotones.palancaActionPerformed(evento);
			assertTrue(c.getPalanca().leerEstado() == Palanca.MANTENIENDO);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}