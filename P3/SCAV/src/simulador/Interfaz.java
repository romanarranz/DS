package simulador;
import javax.swing.*;

import controlVelocidad.*;
import monitorizacion.Monitorizacion;

@SuppressWarnings("serial")
public class Interfaz extends JApplet {
	JLabel etiquetaVelAuto, etiquetaEstado;
	Simulacion simulacion;
	Monitorizacion monitor;
	ControlVelocidad control;
	
	public void init(){
		this.setSize(800,600);
	}
	
	public Interfaz(){
		PanelEtiquetas panelE = new PanelEtiquetas(this);
		PanelBotones panelB = new PanelBotones(this);
		simulacion = new Simulacion(panelE,panelB);
		control = new ControlVelocidad();
		monitor = new Monitorizacion(control.eje);		
		panelE.aniadirComponentes(monitor, control);
		panelB.aniadirComponentes(monitor, control);
		
		Thread s = new Thread(simulacion);
		s.start();
		
		control.start();
		monitor.start();
		add(panelB);		
		add(panelE);
		setVisible(true);
		destroy();
	}
	
	public ControlVelocidad getControlVelocidad(){
		return this.control;
	}
	
	public Monitorizacion getMonitorizacion(){
		return this.monitor;
	}
	
	public Simulacion getSimulacion(){
		return this.simulacion;
	}
	
	public JLabel getEtiquetaEstado(){
		return etiquetaEstado;
	}
}