package simulador;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import controlVelocidad.*;
import monitorizacion.Monitorizacion;
import testMonitorizacion.*;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements Observador {
	Interfaz interfaz;
	JButton BotonAcelerar, BotonParar, BotonMantener, BotonReiniciar, BotonRepostar, BotonRestear;
	JButton botonMecanico1, botonMecanico2, botonMecanico3;
	JToggleButton BotonEncender, BotonFreno;
	Monitorizacion monitor;
	ControlVelocidad control;
	public PanelBotones(Interfaz interfaz) {
		super();
		this.interfaz = interfaz;
		iniciarComponentes();
	}
	public void aniadirComponentes(Monitorizacion monitor, ControlVelocidad control){
		this.monitor=monitor;
		this.control=control;
	}
	private void iniciarComponentes() {
		setLayout(null);
		BotonAcelerar = new JButton("Acelerar");
		BotonAcelerar.setBounds(100,250,100,30);
		this.interfaz.add(BotonAcelerar);
       
		BotonAcelerar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	   	BotonAcelerarActionPerformed(evt); 
	       	}
		});
       BotonParar = new JButton("Parar");
       BotonParar.setBounds(25,300,100,30);
       interfaz.add(BotonParar);
       BotonParar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonPararActionPerformed(evt); 
	       	}
		});
       BotonMantener = new JButton("Mantener");
       BotonMantener.setBounds(175,300,100,30);
       interfaz.add(BotonMantener);
       BotonMantener.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonMantenerActionPerformed(evt); 
	       	}
		});
       BotonReiniciar = new JButton("Reiniciar");
       BotonReiniciar.setBounds(100,350,100,30);
       interfaz.add(BotonReiniciar);
       BotonReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonReiniciarActionPerformed(evt); 
	       	}
		});
        BotonEncender = new JToggleButton("Arrancar");
        BotonEncender.setBounds(450,450,100,30);
        interfaz.add(BotonEncender);
        
        BotonEncender.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	   	BotonEncenderActionPerformed(evt); 
	       	}
		});
        BotonFreno = new JToggleButton("Frenar");
        BotonFreno.setBounds(300,450,100,30);
        interfaz.add(BotonFreno);
        
        BotonFreno.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonFrenoActionPerformed(evt); 
	       	}
		});
        BotonRepostar = new JButton("Repostar");
        BotonRepostar.setBounds(300,500,100,30);
        interfaz.add(BotonRepostar);
        BotonRepostar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonRepostarActionPerformed(evt); 
	       	}
		});
        BotonRestear = new JButton("Resetear");
        BotonRestear.setBounds(450,500,100,30);
        interfaz.add(BotonRestear);
        
        BotonRestear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonRestearActionPerformed(evt); 
	       	}
		});
        botonMecanico1 = new JButton("Mecanico Aceite");
        botonMecanico1.setBounds(600,10,180,30);
        interfaz.add(botonMecanico1);
        botonMecanico1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonMecanico1ActionPerformed(evt); 
	       	}
		});
        botonMecanico2 = new JButton("Mecanico Pastillas");
        botonMecanico2.setBounds(600,110,180,30);
        interfaz.add(botonMecanico2);
        botonMecanico2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonMecanico2ActionPerformed(evt); 
	       	}
		});
        botonMecanico3 = new JButton("Mecanico revision");
        botonMecanico3.setBounds(600,210,180,30);
        interfaz.add(botonMecanico3);
        
        botonMecanico3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotonMecanico3ActionPerformed(evt); 
	       	}
		});
	}
	synchronized private void BotonAcelerarActionPerformed(ActionEvent evt) {
		if(!BotonFreno.isSelected()){
			interfaz.etiquetaEstado.setText("Acelerando");
			control.cambiarPalanca(Palanca.APAGADO);
			control.acelera.pisar();
			control.freno.soltar();
		}
		else{
			interfaz.etiquetaEstado.setText("Parado");
			control.freno.pisar();
		}
	}
	synchronized private void BotonMantenerActionPerformed(ActionEvent evt) {
		interfaz.etiquetaEstado.setText("Manteniendo");
		control.cambiarPalanca(Palanca.MANTENIENDO);
	}
	synchronized private void BotonPararActionPerformed(ActionEvent evt) {
		interfaz.etiquetaEstado.setText("Para SCAV");
		control.cambiarPalanca(Palanca.APAGADO);
		control.freno.soltar();
		control.acelera.soltar();
	}
	synchronized private void BotonReiniciarActionPerformed(ActionEvent evt) {
		interfaz.etiquetaEstado.setText("Reiniciando");
		control.cambiarPalanca(Palanca.REINICIANDO);
		control.freno.soltar();
		control.acelera.soltar();
	}
	synchronized private void BotonFrenoActionPerformed(ActionEvent evt) {		
		if(BotonFreno.isSelected()){
			interfaz.etiquetaEstado.setText("Frenando");
			BotonFreno.setText("Soltar Freno");
			control.cambiarPalanca(Palanca.APAGADO);
			control.freno.pisar();
			control.acelera.soltar();
		}
		else{
			BotonFreno.setText("Frenar");
			control.freno.soltar();
			interfaz.etiquetaEstado.setText("Punto muerto");	
		}
	}
	synchronized private void BotonEncenderActionPerformed(ActionEvent evt) {
		control.motor.cambiarEstado();
		if(BotonEncender.isSelected()){
			BotonEncender.setText("Apagar");
			interfaz.etiquetaEstado.setText("Arrancado");	
		}
		else{
			BotonEncender.setText("Arrancar");
			control.acelera.soltar();
			interfaz.etiquetaEstado.setText("Parado2");	
		}
	}
	synchronized private void BotonRepostarActionPerformed(ActionEvent evt) {
		monitor.cambiarANivelInicial();
	}
	synchronized private void BotonRestearActionPerformed(ActionEvent evt) {
		monitor.reseteo();
	}
	synchronized private void BotonMecanico1ActionPerformed(ActionEvent evt) {
		monitor.mecanicoAceite();
		monitor.NotificaMecanico();	
	}
	synchronized private void BotonMecanico2ActionPerformed(ActionEvent evt) {
		monitor.mecanicoPastillas();
		monitor.NotificaMecanico();
	}
	synchronized private void BotonMecanico3ActionPerformed(ActionEvent evt) {
		monitor.mecanicoGeneral();
		monitor.NotificaMecanico();
	}
	private void activarBotones() {
		if(control.motor.leerEstado()){
			BotonAcelerar.setEnabled(true);
			if(control.acelera.leerEstado() && !(control.estadoPalanca.leerEstado() == Palanca.MANTENIENDO || control.estadoPalanca.leerEstado() == Palanca.REINICIANDO)){
				BotonMantener.setEnabled(true);
				BotonReiniciar.setEnabled(true);
			}
			if(control.estadoPalanca.leerEstado() == Palanca.MANTENIENDO || control.estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				BotonAcelerar.setEnabled(true);
				BotonParar.setEnabled(true);
			}
			if(control.estadoPalanca.leerEstado() == Palanca.APAGADO){
				BotonAcelerar.setEnabled(true);
				BotonReiniciar.setEnabled(true);
			}
		}
		else{
			if(control.obtenerVel() == 0){
				BotonRepostar.setEnabled(true);
				BotonRestear.setEnabled(true);
				botonMecanico1.setEnabled(true);
				botonMecanico2.setEnabled(true);
				botonMecanico3.setEnabled(true);
			}
		}
	}
	private void desactivarBotones() {
		if(control.motor.leerEstado()){
			BotonRepostar.setEnabled(false);
			BotonRestear.setEnabled(false);
			botonMecanico1.setEnabled(false);
			botonMecanico2.setEnabled(false);
			botonMecanico3.setEnabled(false);
			if(control.acelera.leerEstado() && !(control.estadoPalanca.leerEstado() == Palanca.MANTENIENDO || control.estadoPalanca.leerEstado() == Palanca.REINICIANDO)){
				BotonParar.setEnabled(false);
				BotonAcelerar.setEnabled(false);
			}
			if(control.estadoPalanca.leerEstado() == Palanca.MANTENIENDO || control.estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				BotonMantener.setEnabled(false);
				BotonReiniciar.setEnabled(false);
			}
			if(control.estadoPalanca.leerEstado() == Palanca.APAGADO && !control.acelera.leerEstado()){
				BotonParar.setEnabled(false);
				BotonMantener.setEnabled(false);
			}
		}
		else{
			BotonAcelerar.setEnabled(false);
			BotonParar.setEnabled(false);
			BotonMantener.setEnabled(false);
			BotonReiniciar.setEnabled(false);
		}
	}
	@Override
	public void actualizar() {
		activarBotones();
		desactivarBotones();
	}
}