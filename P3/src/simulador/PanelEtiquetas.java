package simulador;
import java.awt.*;

import javax.swing.*;

import controlVelocidad.*;
import monitorizacion.Monitorizacion;
import monitorizacion.Notificaciones;

@SuppressWarnings("serial")
public class PanelEtiquetas extends JPanel implements Observador {
	Interfaz interfaz;
	JLabel etiquetaKmsV, etiquetaKmtV, etiquetaRotacionV, etiquetaRotaciontV, etiquetaVelMediaV, etiquetaCombustibleV, etiquetaCombustibleMV;
	JLabel etiquetaNotifi1, etiquetaNotifi2, etiquetaNotifi3;
	Monitorizacion monitor;
	ControlVelocidad control;
	public void paint (Graphics g) {
		super.paint(g);
		g.drawRoundRect(5, 5, 225, 220, 20, 20);  
		g.drawRect(100, 10, 100, 30); 		
		g.drawRect(100, 55, 100, 30);		
		g.drawRect(100, 95, 100, 30);		
		g.drawRect(100, 135, 100, 30);		
		g.drawRect(100, 180, 100, 30);
		g.drawRect(100, 445, 100, 30);
		g.drawRect(100, 495, 100, 30);
		g.drawRoundRect(345, 5, 225, 400, 20, 20); 
		g.drawRect(370, 15, 175, 40); 
		g.drawRect(400, 100, 100, 30); 
		g.drawRect(370, 165, 175, 40); 
		g.drawRect(370, 225, 175, 40); 
		g.drawRect(370, 275, 175, 40); 
	}
	public PanelEtiquetas(Interfaz interfaz){
		super();
		this.interfaz = interfaz;
		iniciarComponentes();
	}

	public void aniadirComponentes(Monitorizacion monitor, ControlVelocidad control){
		this.monitor=monitor;
		this.control=control;
	}
	private void iniciarComponentes() {
		setBackground(new java.awt.Color(200, 255, 255));
		setLayout(null);
		JLabel etiquetaKms = new JLabel("Km/h");
		etiquetaKms.setFont(new java.awt.Font("Tahoma", 0, 25));
		etiquetaKms.setBounds(15,15,100,20);
		add(etiquetaKms);	
		etiquetaKmsV = new JLabel("------");
		etiquetaKmsV.setFont(new java.awt.Font("Tahoma", 0, 20));
		etiquetaKmsV.setBounds(125,15,100,20);
		add(etiquetaKmsV);
		JLabel etiquetaKmT = new JLabel("Km total");
		etiquetaKmT.setFont(new java.awt.Font("Tahoma", 1, 15));
		etiquetaKmT.setBounds(15,60,100,20);
		add(etiquetaKmT);
		etiquetaKmtV = new JLabel("------");
		etiquetaKmtV.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaKmtV.setBounds(125,60,70,20);
		add(etiquetaKmtV);	
		JLabel etiquetaRotacion = new JLabel("Rev/min");
		etiquetaRotacion.setFont(new java.awt.Font("Tahoma", 0, 20));
		etiquetaRotacion.setBounds(15,100,100,20);
		add(etiquetaRotacion);
		etiquetaRotacionV = new JLabel("------");
		etiquetaRotacionV.setFont(new java.awt.Font("Tahoma", 0, 20));
		etiquetaRotacionV.setBounds(125,100,100,20);
		add(etiquetaRotacionV);
		JLabel etiquetaRotacionT = new JLabel("Rev total");
		etiquetaRotacionT.setFont(new java.awt.Font("Tahoma", 1, 15));
		etiquetaRotacionT.setBounds(15,140,100,20);
		add(etiquetaRotacionT);
		etiquetaRotaciontV = new JLabel("------");
		etiquetaRotaciontV.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaRotaciontV.setBounds(125,140,100,20);
		add(etiquetaRotaciontV);
		JLabel etiquetaVelMedia = new JLabel("Vel media");
		etiquetaVelMedia.setFont(new java.awt.Font("Tahoma", 1, 15));
		etiquetaVelMedia.setBounds(15,185,100,20);
		add(etiquetaVelMedia);
		etiquetaVelMediaV = new JLabel("------");
		etiquetaVelMediaV.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaVelMediaV.setBounds(125,185,100,20);
		add(etiquetaVelMediaV);
		JLabel etiquetaConbustible = new JLabel("Gas");
		etiquetaConbustible.setFont(new java.awt.Font("Tahoma", 0, 25));
		etiquetaConbustible.setBounds(15,450,100,20);
		add(etiquetaConbustible);
		etiquetaCombustibleV = new JLabel("------");
		etiquetaCombustibleV.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaCombustibleV.setBounds(125,450,60,20);
		add(etiquetaCombustibleV);
		JLabel etiquetaConbustibleM = new JLabel("Gas medio");
		etiquetaConbustibleM.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaConbustibleM.setBounds(15,500,100,20);
		add(etiquetaConbustibleM);
		etiquetaCombustibleMV = new JLabel("------");
		etiquetaCombustibleMV.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaCombustibleMV.setBounds(125,500,60,20);
		add(etiquetaCombustibleMV);		
		
		interfaz.etiquetaEstado = new JLabel("Estado");
		interfaz.etiquetaEstado.setForeground(Color.RED);
		interfaz.etiquetaEstado.setFont(new java.awt.Font("Tahoma", 0, 15));
		interfaz.etiquetaEstado.setBounds(400,20,100,30);
		add(interfaz.etiquetaEstado);
		
		JLabel etiquetaTextoVel = new JLabel("Velocidad Automatica");
		etiquetaTextoVel.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaTextoVel.setBounds(380,65,200,30);
		add(etiquetaTextoVel);

		interfaz.etiquetaVelAuto = new JLabel("---");
		interfaz.etiquetaVelAuto.setFont(new java.awt.Font("Tahoma", 0, 25));
		interfaz.etiquetaVelAuto.setBounds(430, 100,100,30);
		add(interfaz.etiquetaVelAuto);
		
		JLabel etiquetaTextoNotifi = new JLabel("Notificaciones:");
		etiquetaTextoNotifi.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaTextoNotifi.setBounds(400,135,200,30);
		add(etiquetaTextoNotifi);
		
		etiquetaNotifi1 = new JLabel("1---");
		etiquetaNotifi1.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaNotifi1.setBounds(400, 170,100,30);
		add(etiquetaNotifi1);
		
		etiquetaNotifi2 = new JLabel("2---");
		etiquetaNotifi2.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaNotifi2.setBounds(400, 230,100,30);
		add(etiquetaNotifi2);
		
		etiquetaNotifi3 = new JLabel("3---");
		etiquetaNotifi3.setFont(new java.awt.Font("Tahoma", 0, 15));
		etiquetaNotifi3.setBounds(400, 280,100,30);
		add(etiquetaNotifi3);
		
	}
	synchronized void mostrarVelocidad() {
		etiquetaKmsV.setText(Integer.toString(control.obtenerVel()));
		etiquetaKmtV.setText((Double.toString(control.obtenerDist())));
		interfaz.etiquetaVelAuto.setText(Integer.toString(control.leerVelSeleccionada()));
		etiquetaVelMediaV.setText(Double.toString(monitor.comprobarvelMed()));
		
		interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Mostrar Velocidad"));
	}
	synchronized void mostrarRevoluciones() {
		etiquetaRotacionV.setText(Integer.toString(control.obtenerRev()));
		etiquetaRotaciontV.setText(Long.toString(control.obtenerRevtotal()));
		
		interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Mostrar Revoluciones"));
	}
	synchronized private void mostrarNotificaciones() {
		String notificacionAceite = monitor.comprobarNotificacionesAceite();
		String notificacionPastillas = monitor.comprobarNotificacionesPastillas();
		String notificacionRev = monitor.comprobarNotificacionesGeneral();
		if(notificacionAceite == Notificaciones.NOTIFACEITE){
			etiquetaNotifi1.setText(notificacionAceite);
			
			interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Notifica Aceite"));
		}
		else{
			etiquetaNotifi1.setText("1---");
		}
		if(notificacionPastillas == Notificaciones.NOTIFPASTILLAS){
			etiquetaNotifi2.setText(notificacionPastillas);
						
			interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Notifica Pastillas"));
		}
		else{
			etiquetaNotifi2.setText("2---");
		}
		if(notificacionRev == Notificaciones.NOTIFREV){
			etiquetaNotifi3.setText(notificacionRev);
		
			interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Notifica Revision"));
		}
		else{
			etiquetaNotifi3.setText("3---");
		}
	}
	
	private void mostrarGasolina() {
		etiquetaCombustibleV.setText(Double.toString(monitor.comprobarCombustible()));	
		etiquetaCombustibleMV.setText(Double.toString(monitor.comprobarCombustibleMedio()));
		
		interfaz.getSimulacion().getEventosProducidos().get(this).add(new String("Mostrar Gasolina"));
	}
	
	@Override
	public void actualizar() {
		mostrarVelocidad();
		mostrarRevoluciones();
		mostrarGasolina();
		mostrarNotificaciones();
		interfaz.repaint();
	}
	
	public ControlVelocidad getControlVelocidad(){
		return this.control;
	}
	public Monitorizacion getMonitorizacion(){
		return this.monitor;
	}
}