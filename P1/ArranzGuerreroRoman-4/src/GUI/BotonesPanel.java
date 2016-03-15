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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JLabel;

public class BotonesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JToggleButton encenderApagar;
	private JButton acelerar;

	public BotonesPanel() {
		setBackground(new Color(240,240,240));
		this.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.WHITE));
		
		SpringLayout spLayout = new SpringLayout();
		this.setLayout(spLayout);
		
		JLabel estado= new JLabel("APAGADO");		
		estado.setVerticalAlignment(SwingConstants.TOP);
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setForeground(Color.RED);
		estado.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.LIGHT_GRAY));
		
		spLayout.putConstraint(SpringLayout.SOUTH, estado, 54, SpringLayout.NORTH, this);
		spLayout.putConstraint(SpringLayout.WEST, estado, 0, SpringLayout.WEST, this);
		spLayout.putConstraint(SpringLayout.EAST, estado, 0, SpringLayout.EAST, this);
		spLayout.putConstraint(SpringLayout.NORTH, estado, 10, SpringLayout.NORTH, this);	
			
		// añado el label del estado del vehiculo
		this.add(estado);
		
		encenderApagar = new JToggleButton("Encender");
		encenderApagar.setForeground(Color.RED);
		
		spLayout.putConstraint(SpringLayout.SOUTH, encenderApagar, -29, SpringLayout.SOUTH, this);
		spLayout.putConstraint(SpringLayout.EAST, encenderApagar, -233, SpringLayout.EAST, this);
		
		// añado boton de encendido apagado para el vehiculo
		this.add(encenderApagar);
		
		// cuando se presione el boton de encedido/apagado
		encenderApagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// si estaba seleccionado
				if(encenderApagar.isSelected()) {
					encenderApagar.setForeground(new Color(255,255,255));
					estado.setText("ENCENDIDO");
					acelerar.setEnabled(true);
				}
				else {
					encenderApagar.setForeground(Color.RED);
					estado.setText("APAGADO");
					acelerar.setEnabled(false);
				}
			}
		});
		
		acelerar = new JButton("Acelerar");
		
		spLayout.putConstraint(SpringLayout.NORTH, acelerar, 0, SpringLayout.NORTH, encenderApagar);		
		spLayout.putConstraint(SpringLayout.WEST, acelerar, 22, SpringLayout.EAST, encenderApagar);
		
		acelerar.setEnabled(false);
		
		// añadimos el boton de acelerar
		this.add(acelerar);
		
		// cuando se pulse sobre el boton de acelerar
		acelerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(encenderApagar.isSelected()) {
					estado.setText("ACELERANDO");
				}
			}
		});
	}
}