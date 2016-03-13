package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class AppWindow {

	private JPanel contentPane, estadisticasPanel;
	private JFrame frame;
	
	private JButton btnActualizarTemperatura;
	private JLabel lTemperatura, googleMaps;
	
	public AppWindow() {
		
		frame = new JFrame("Monitor de Temperaturas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 962, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(610, 10, 303, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lTemperatura = new JLabel("0ºC");
		lTemperatura.setForeground(Color.ORANGE);
		lTemperatura.setFont(new Font("Helvetica Neue", Font.PLAIN, 44));
		lTemperatura.setBounds(112, 65, 126, 53);
		panel.add(lTemperatura);
		
		btnActualizarTemperatura = new JButton("Actualizar");
		btnActualizarTemperatura.setBounds(90, 146, 117, 29);
		panel.add(btnActualizarTemperatura);
		
		GoogleMapsSnippet gmaps = new GoogleMapsSnippet();
		googleMaps = gmaps.getMapa();
		googleMaps.setBounds(6, 10, 600, 494);
		contentPane.add(googleMaps);
		
		TimerSeriesTemperatura tchart = new TimerSeriesTemperatura(); 
		estadisticasPanel = new JPanel();
		estadisticasPanel.setBackground(Color.WHITE);
		estadisticasPanel.setBounds(6, 192, 950, 426);
		estadisticasPanel.add(tchart.getPanelChart(), BorderLayout.CENTER);
		estadisticasPanel.add(tchart.getBtnPanel(), BorderLayout.SOUTH);
		contentPane.add(estadisticasPanel);
		
		frame.setVisible(true);
		//tchart.start();
	}
	
	public void setTemperaturaActual(int temperatura){
		lTemperatura.setText(Integer.toString(temperatura)+"ºC");
	}
}
