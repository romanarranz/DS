package testSimulador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simulador.Interfaz;
import simulador.Observador;
import simulador.PanelBotones;
import simulador.Simulacion;

public class ListaObservadoresObservablesTest extends Thread {
	
	private Interfaz i;
	private Simulacion s;
	private List<Observador> l;
	private ObservadorTestListener oT;
	private boolean err;
	
	@BeforeClass
	public static void init(){
		System.out.println("# ListaObservadoresObservablesTest");
	}
	
	@Before
	public void testInit(){
		i = new Interfaz();
		oT = new ObservadorTestListener(i);		
		s = i.getSimulacion();
		l = s.getObservadores();
	    err = false;
	}
	
	@Test
	public void testInicializacion(){
		System.out.print("\ttestInicializacion...");
		try {
			assertNotNull(l);
			assertTrue(l.get(0) instanceof Observador);	
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testInsertaObservador(){
		System.out.print("\ttestInsertaObservador...");
		try {
			// cuando se llama cualquier @Test se ejecuta @Before por lo tanto se habrá inicialzado
			// la interfaz y se habran añadido 2 observadores a la lista de observadores
			assertEquals(l.size(), 2);
			
			// comprobamos adicionalmente que pertenecen a la clase Observador
			for(Object o: l){
				assertTrue(o instanceof Observador);
			}
			
			// no obstante pruebo a añadir otro mas
			int size = l.size();
			s.incluir(oT);
			assertTrue(size < l.size());
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testNotificarObservadores(){
		System.out.print("\ttestNotificarObservadores...");
		try{
			List<Object> eventosPanelBotones = new ArrayList<Object>();
			s.incluir(oT);
			
			// arrancamos el motor
			MouseEvent me = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
			ActionEvent ae = new ActionEvent(me.getSource(), me.getID(), me.paramString());
			
			// encender
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			eventosPanelBotones.add(new String("Parado2"));			
			
			// Acelerador: pulso boton
			i.getSimulacion().getPanelBotones().toggleAcelerador();
			i.getSimulacion().getPanelBotones().BotonAcelerarActionPerformed(ae);
			eventosPanelBotones.add(new String("Acelerando"));
			
			// Mantener velocidad
			i.getSimulacion().getPanelBotones().BotonMantenerActionPerformed(ae);			
			eventosPanelBotones.add(new String("Manteniendo"));
			
			// esperamos 1 segundo para que intervengan varias actualizaciones del patron observador
			try{
				Thread.sleep(1000);
			}
			catch(java.lang.InterruptedException e){
				e.printStackTrace();	
			}
			
			// Apagando el motor
			i.getSimulacion().getPanelBotones().BotonEncenderActionPerformed(ae);
			eventosPanelBotones.add(new String("Parado2"));
			
			/*
			System.out.println();
			for (Map.Entry<Observador, List<Object>> entry : s.getEventosProducidos().entrySet())				
			    System.out.println(entry.getKey().getClass().getSimpleName() + "\n\t" + entry.getValue().toString());
			*/
			
			// la lista que hemos definido debe coincidir con la misma lista de eventos que tenga ese observador 
			// que ha ido rellenando 
			PanelBotones pb = s.getPanelBotones();
			assertEquals(eventosPanelBotones, s.getEventosProducidos().get(pb));			
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		catch(Exception e){
			System.out.print("\tnot ok\n");
			err = true;
			e.printStackTrace();
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
	
	@Test
	public void testEliminaObservador(){
		System.out.print("\ttestEliminaObservador...");
		try {
			
			// elimino un observador
			int size = l.size();
			l.remove(0);
			
			assertTrue(size > l.size());
			
			// elimino todos los observadores
			l.clear();
			assertEquals(l.size(), 0);
		}
		catch(AssertionError e){
			System.out.print("\tnot ok\n");
			err = true;
			throw e;
		}
		
		if(!err) System.out.print("\tok\n");
	}
}
