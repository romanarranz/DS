package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Display {

	private JPanel contentPane;
	private JFrame frame;

	private JLabel lTemperatura;
	/**
	 * Create the frame.
	 */
	public Display() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(6, 6, 438, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lTemperatura = new JLabel("0ºC");
		lTemperatura.setForeground(Color.RED);
		lTemperatura.setFont(new Font("Helvetica Neue", Font.PLAIN, 44));
		lTemperatura.setBounds(178, 66, 108, 117);
		panel.add(lTemperatura);
		frame.setVisible(true);
	}
	
	public void setTemperaturaActual(int temperatura){
		lTemperatura.setText(Integer.toString(temperatura)+"ºC");
	}
}
