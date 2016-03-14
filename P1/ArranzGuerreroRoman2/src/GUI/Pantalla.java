package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejer2.Observador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Pantalla implements Observador{
	private static Pantalla INSTANCE = new Pantalla();
	
	private JPanel contentPane, graficaPane, panel;
	private JFrame frame;
	
	private BotonCambio actualiza;
	private JLabel lTemperatura, googleMaps;
	
	private GraficaTemperatura tchart;
	private  TiempoSatelital gmaps;
	
	public Pantalla() {
		frame = new JFrame("Monitor de Temperaturas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 952, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
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
	}
	
	public void inicializar(BotonCambio btn){
		actualiza = btn;
		actualiza.setBounds(90, 146, 117, 29);		
		panel.add(actualiza);
		
		gmaps = new TiempoSatelital();
		googleMaps = gmaps.getMapa();
		googleMaps.setBounds(6, 10, 600, 494);
		contentPane.add(googleMaps);
		
		this.tchart = new GraficaTemperatura("Temperaturas");
		graficaPane = new JPanel();
		graficaPane.setBackground(Color.WHITE);
		graficaPane.setBounds(610, 203, 336, 415);
		graficaPane.add(tchart.getPanelChart());
		graficaPane.setLayout(null);
		
		contentPane.add(graficaPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 510, 600, 108);
		panel_1.add(tchart.getBtnPanel());
		contentPane.add(panel_1);
		
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
