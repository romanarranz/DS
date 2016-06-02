package simulador;
import java.awt.Frame;
import java.awt.event.WindowEvent;

public class Lanzador {
	public static void main (String [ ] args) {
		Frame ventana = new Frame ("Simulador SCACV--Desarrollo de Software (ETSIIT)");
		Interfaz interfaz = new Interfaz();
		ventana.add(interfaz);
		interfaz.init ();
		ventana.setSize (800, 600);
		ventana.setVisible (true);
		ventana.addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(WindowEvent winEvt) {
		        System.exit(0); 
		    }
		});
	}
}