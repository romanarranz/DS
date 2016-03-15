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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ejer2.Observador;
import ejer2.Simulador;

public class BotonCambio extends JButton implements Observador{
	private static final long serialVersionUID = 1L;
	
	public BotonCambio(Simulador s){
		super("Actualizar");
		
		// cada vez que se le pulse actualiza la temperatura y notifica a los observadores
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.actualizaTemperaturaMinMax();
				s.notificar(s.getTemperaturaActual());
			}
		});
	}
	
	// el boton no tiene que realizar ninguna accion especial, pero como observador 
	// si tiene que implementar el metodo manejarEvento 
	public void manejarEvento(int temperaturaActual){}
}
