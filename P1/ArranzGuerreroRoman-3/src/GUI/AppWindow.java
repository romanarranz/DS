/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 3
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

public class AppWindow {
	// Singleton
	private static AppWindow INSTANCE = new AppWindow();
	
	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private JScrollPane scroll;
	private Tabla model;
	
	private AppWindow() {
		// <== Ventana
		// ============================>
		frame = new JFrame("Configuracion de Equipos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
        
		// <== Tabla
		// ============================>
		model = new Tabla();		
		table = new JTable(model);
		
		// tabla scrollable
		scroll = new JScrollPane(table);
		scroll.setSize(400, 200);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		frame.setVisible(true);
	}
	
	public static AppWindow getInstance() {
        return INSTANCE;
    }
	
	public void addRow(){
		model.addRow();
	}
	
	public void setDato(int fila, int columna, Object dato){
		model.setDato(fila,columna,dato);
	}
}
