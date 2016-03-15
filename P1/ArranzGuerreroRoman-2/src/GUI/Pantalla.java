/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 2
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejer2.Observador;
import ejer2.Simulador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Pantalla implements Observador{
	private static Pantalla INSTANCE = new Pantalla();
	
	private JPanel contentPane, graficaPane, panel, controlesPanel;
	private JFrame frame;
	
	private BotonCambio actualiza;
	private JLabel lTemperatura, googleMaps;
	
	private GraficaTemperatura tchart;
	private TiempoSatelital gmaps;
	private JButton run;
	private JComboBox<String> combo;
	private String start, stop;
	
	private Pantalla() {
		// <== Ventana
		// ==================================>
		frame = new JFrame("Monitor de Temperaturas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 810, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// <== Panel de Temperatura
		// ==================================>
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(460, 5, 345, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lTemperatura = new JLabel("0ºC");
		lTemperatura.setForeground(Color.ORANGE);
		lTemperatura.setFont(new Font("Helvetica Neue", Font.PLAIN, 44));
		lTemperatura.setBounds(132, 86, 126, 53);
		panel.add(lTemperatura);
		
		JLabel lblTemperaturaEnCelsius = new JLabel("Temperatura en Celsius");
		lblTemperaturaEnCelsius.setFont(new Font("Helvetica Neue", Font.PLAIN, 26));
		lblTemperaturaEnCelsius.setForeground(Color.WHITE);
		lblTemperaturaEnCelsius.setBounds(53, 21, 286, 53);
		panel.add(lblTemperaturaEnCelsius);
	}
	
	public void inicializar(BotonCambio btn, Simulador s){
		// <== Boton actualizar
		// ==================================>
		actualiza = btn;
		actualiza.setBounds(110, 146, 117, 29);		
		panel.add(actualiza);
		
		// <== Panel imagenes satelitales
		// ==================================>
		gmaps = new TiempoSatelital();
		googleMaps = gmaps.getMapa();
		googleMaps.setBounds(5, 5, 450, 320);
		contentPane.add(googleMaps);
		
		// <== Panel grafica de temperaturas
		// ==================================>
		this.tchart = new GraficaTemperatura("Temperaturas");
		graficaPane = new JPanel();
		graficaPane.setBackground(Color.WHITE);
		graficaPane.setBounds(5, 330, 800, 285);
		graficaPane.add(tchart.getPanelChart());
		graficaPane.setLayout(null);
		
		contentPane.add(graficaPane);		

		// <== Panel de control de velocidad y boton para parar/continuar
		// ==================================>
		controlesPanel= new JPanel();
		controlesPanel.setBackground(Color.DARK_GRAY);
		controlesPanel.setBounds(460, 200, 345, 125);
		
		// <== Boton parar/continuar ejecucion
		// ==================================>
		start = "Continuar";
		stop = "Parar";
		run = new JButton(stop);
		run.setBounds(50, 50, 110, 30);
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (stop.equals(cmd)) {
					s.parar();
					run.setText(start);
				} else {
					s.comenzar();
					Thread t1 = new Thread(s);
					t1.start();
					run.setText(stop);
				}
			}
		});
		
		// <== Selector de velocidad
		// ==================================>
		combo = new JComboBox<String>();
		combo.setBounds(180,50,120,30);
		combo.addItem("Lento");
		combo.addItem("Rapido");
		combo.addItem("Muy Rapido");
		combo.addActionListener(new ActionListener() {	        
			@Override
	        public void actionPerformed(ActionEvent e) {
	            if ("Rapido".equals(combo.getSelectedItem())) {
	            	s.refrescoRapido();
	            }
	            else if ("Muy Rapido".equals(combo.getSelectedItem()))  {
	            	s.refrescoMuyRapido();
	            }
	            else {
	                s.refrescoLento();
	            }
	        }
		});
		
		controlesPanel.add(run);
		controlesPanel.add(combo);
		controlesPanel.setLayout(null);
		contentPane.add(controlesPanel);
		
		frame.setVisible(true);
	}
	
	public static Pantalla getInstance() {
        return INSTANCE;
    }
	
	private void setTemperaturaActual(int temperatura){
		lTemperatura.setText(Integer.toString(temperatura)+"ºC");
		tchart.actualizaTemperatura(temperatura);
		actualizaMapa();
	}
	
	public void actualizaMapa(){
		googleMaps.setIcon(gmaps.actualiza());
	}

	@Override
	public void manejarEvento(int temperaturaActual) {
		setTemperaturaActual(temperaturaActual);
	}
}
