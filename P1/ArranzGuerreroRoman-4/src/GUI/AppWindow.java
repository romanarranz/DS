/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 4
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AppWindow {
	private static AppWindow INSTANCE = new AppWindow();
	
	private BotonesPanel btnPanel;
	private JFrame frame;
	
	private AppWindow() {
		frame = new JFrame("Sistema de conduccion automatica del vehiculo");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 150);
		btnPanel = new BotonesPanel();
		frame.getContentPane().add(btnPanel);
		
		frame.addWindowListener (new WindowAdapter(){ 
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public static AppWindow getInstance() {
		return INSTANCE;
	}

	public void ejecutar(Object o) {
		frame.setVisible(true);
	}
}