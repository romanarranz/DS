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
	private static AppWindow INSTANCE = new AppWindow();
	
	private JPanel contentPane, graficaPane;
	private JFrame frame;
	
	private JButton botonCambio;
	private JLabel lTemperatura, googleMaps;
	
	private TimerSeriesTemperatura tchart;
	private  GoogleMapsSnippet gmaps;
	
	public AppWindow() {
		
		frame = new JFrame("Monitor de Temperaturas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 952, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(610, 6, 336, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lTemperatura = new JLabel("0ºC");
		lTemperatura.setForeground(Color.ORANGE);
		lTemperatura.setFont(new Font("Helvetica Neue", Font.PLAIN, 44));
		lTemperatura.setBounds(112, 65, 126, 53);
		panel.add(lTemperatura);
		
		botonCambio = new JButton("Actualizar");
		botonCambio.setBounds(90, 146, 117, 29);
		panel.add(botonCambio);
		
		gmaps = new GoogleMapsSnippet();
		googleMaps = gmaps.getMapa();
		googleMaps.setBounds(6, 10, 600, 494);
		contentPane.add(googleMaps);
		
		this.tchart = new TimerSeriesTemperatura("Temperaturas");
		graficaPane = new JPanel();
		graficaPane.setBackground(Color.WHITE);
		//graficaPane.setBounds(6, 192, 950, 426);
		graficaPane.setBounds(610, 203, 336, 415);
		//graficaPane.add(tchart.getPanelChart(), BorderLayout.CENTER);
		graficaPane.add(tchart.getPanelChart());
		//graficaPane.add(tchart.getBtnPanel(), BorderLayout.SOUTH);
		//graficaPane.add(tchart.getBtnPanel());
		
		graficaPane.setLayout(null);
		
		contentPane.add(graficaPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 510, 600, 108);
		panel_1.add(tchart.getBtnPanel());
		contentPane.add(panel_1);
		
		frame.setVisible(true);
		//tchart.start();
	}
	
	public static AppWindow getInstance() {
        return INSTANCE;
    }
	
	public void setTemperaturaActual(int temperatura){
		lTemperatura.setText(Integer.toString(temperatura)+"ºC");
		tchart.actualizaTemperatura(temperatura);
	}
}
