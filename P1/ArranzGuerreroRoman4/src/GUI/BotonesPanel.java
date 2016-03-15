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

@SuppressWarnings("serial")
public class BotonesPanel extends JPanel {
	
	private JToggleButton TurnOnButton;
	private JButton SpeedUpButton;

	public BotonesPanel() {
		setBackground(new Color(240,240,240));
		this.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.WHITE));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblState= new JLabel("APAGADO");
		springLayout.putConstraint(SpringLayout.SOUTH, lblState, 54, SpringLayout.NORTH, this);
		lblState.setVerticalAlignment(SwingConstants.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, lblState, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblState, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblState, 0, SpringLayout.EAST, this);
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setForeground(Color.RED);
		lblState.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.LIGHT_GRAY));
		add(lblState);
		
		TurnOnButton = new JToggleButton("Encender");
		springLayout.putConstraint(SpringLayout.SOUTH, TurnOnButton, -29, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, TurnOnButton, -233, SpringLayout.EAST, this);
		TurnOnButton.setForeground(Color.RED);
		add(TurnOnButton);
		
		TurnOnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TurnOnButton.isSelected()) {
					TurnOnButton.setForeground(new Color(255,255,255));
					lblState.setText("ENCENDIDO");
					SpeedUpButton.setEnabled(true);
				}
				else {
					TurnOnButton.setForeground(Color.RED);
					lblState.setText("APAGADO");
					SpeedUpButton.setEnabled(false);
				}
			}
		});
		
		SpeedUpButton = new JButton("Acelerar");
		springLayout.putConstraint(SpringLayout.NORTH, SpeedUpButton, 0, SpringLayout.NORTH, TurnOnButton);
		springLayout.putConstraint(SpringLayout.WEST, SpeedUpButton, 22, SpringLayout.EAST, TurnOnButton);
		SpeedUpButton.setEnabled(false);
		add(SpeedUpButton);
		
		SpeedUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TurnOnButton.isSelected()) {
					lblState.setText("ACELERANDO");
				}
			}
		});
	}
}