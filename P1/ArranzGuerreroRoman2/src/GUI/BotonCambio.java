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
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.actualizaTemperaturaMinMax();
				s.notificar(s.getTemperaturaActual());
			}
		});
	}
	
	public void manejarEvento(int temperaturaActual){}
}
