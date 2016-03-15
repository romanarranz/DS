/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 1
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class AppWindow {
	// Singleton
	private static AppWindow INSTANCE = new AppWindow();

	private JPanel contentPane;
	private JFrame frame; 
	 
	private JLabel crono, montanaEnCabeza, montanaGanador, montanaKM,
	  			   carreteraEnCabeza, carreteraGanador, carreteraKM,
	  			   participantesMontana, participantesCarretera;
	
	private AppWindow() {
		
		// <== Ventana
		// ==========================================>
		frame = new JFrame("Carrera de bicicletas");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// <== Panel de la izquierda
		// ==========================================>
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.WHITE);
		panelIzq.setBounds(6, 83, 213, 189);
		contentPane.add(panelIzq);
		panelIzq.setLayout(null);
		
		montanaEnCabeza = new JLabel();
		montanaEnCabeza.setBounds(6, 94, 201, 16);
		montanaEnCabeza.setText("En Cabeza:");
		panelIzq.add(montanaEnCabeza);
		
		montanaGanador = new JLabel();
		montanaGanador.setText("Ganador:");
		montanaGanador.setBounds(6, 150, 201, 16);
		panelIzq.add(montanaGanador);
		
		JLabel lblCarreraDeMontaa = new JLabel("Carrera de Montaña");
		lblCarreraDeMontaa.setBounds(32, 6, 157, 20);
		lblCarreraDeMontaa.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		panelIzq.add(lblCarreraDeMontaa);
		
		montanaKM = new JLabel();
		montanaKM.setBounds(6, 122, 201, 16);
		panelIzq.add(montanaKM);
		montanaKM.setText("KM:");
		
		participantesMontana = new JLabel("Participantes: ");
		participantesMontana.setBounds(6, 66, 201, 16);
		panelIzq.add(participantesMontana);
		
		// <== Panel de la derecha
		// ==========================================>
		JPanel panelDer = new JPanel();
		panelDer.setBackground(Color.WHITE);
		panelDer.setBounds(222, 83, 222, 189);
		contentPane.add(panelDer);
		panelDer.setLayout(null);
		
		JLabel lblCarreraDeCarretera = new JLabel("Carrera de Carretera");
		lblCarreraDeCarretera.setBounds(33, 5, 156, 20);
		lblCarreraDeCarretera.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		panelDer.add(lblCarreraDeCarretera);
		
		carreteraEnCabeza = new JLabel();
		carreteraEnCabeza.setBounds(6, 93, 210, 16);
		panelDer.add(carreteraEnCabeza);
		carreteraEnCabeza.setText("En Cabeza:");
		
		carreteraGanador = new JLabel();
		carreteraGanador.setBounds(6, 149, 210, 16);
		panelDer.add(carreteraGanador);
		carreteraGanador.setText("Ganador:");
		
		carreteraKM = new JLabel();
		carreteraKM.setBounds(6, 121, 210, 16);
		panelDer.add(carreteraKM);
		carreteraKM.setText("KM:");
		
		participantesCarretera = new JLabel("Participantes: ");
		participantesCarretera.setBounds(6, 65, 210, 16);
		panelDer.add(participantesCarretera);
		
		// <== Panel del cronometro
		// ==========================================>
		JPanel panelCronometro = new JPanel();
		panelCronometro.setBackground(Color.DARK_GRAY);
		panelCronometro.setBounds(6, 6, 438, 74);
		contentPane.add(panelCronometro);
		panelCronometro.setLayout(null);
		
		crono = new JLabel("0s");
		crono.setBounds(197, 6, 88, 62);
		crono.setForeground(Color.ORANGE);
		crono.setFont(new Font("Andale Mono", Font.PLAIN, 30));
		panelCronometro.add(crono);
		
		frame.setVisible(true);
	}
	
	public void setCrono(String text){
		crono.setText(text);
	}
	 
	public void setCrono(int segundos){
		crono.setText(Integer.toString(segundos)+"s");
	}
	
	public void setMontanaEnCabeza(int numeroBicicleta){
		montanaEnCabeza.setText("En cabeza: Bicicleta "+numeroBicicleta);
	}
	
	public void setMontanaKM(int km){
		montanaKM.setText("KM: Bicicleta "+km);
	}
	
	public void setMontanaGanador(int ganador){
		montanaGanador.setText("Ganador: Bicicleta "+ganador);
	}
	
	public void setParticipantesMontana(int activos, int total){
		participantesMontana.setText("Participantes: "+Integer.toString(activos)+"/"+Integer.toString(total));
	}
	
	public void setCarreteraEnCabeza(int numeroBicicleta){
		carreteraEnCabeza.setText("En cabeza: Bicicleta "+numeroBicicleta);
	}

	public void setCarreteraKM(int km){
		carreteraKM.setText("KM: Bicicleta "+km);
	}

	public void setCarreteraGanador(int ganador){
		carreteraGanador.setText("Ganador: Bicicleta "+ganador);
	}
	
	public void setParticipantesCarretera(int activos, int total){
		participantesCarretera.setText("Participantes: "+Integer.toString(activos)+"/"+Integer.toString(total));
	}
	
	// obtener instancia de la ventana siguiendo el patron singleton
	public static AppWindow getInstance() {
        return INSTANCE;
    }
}
