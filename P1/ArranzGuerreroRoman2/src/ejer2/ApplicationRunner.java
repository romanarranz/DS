package ejer2;

import GUI.Pantalla;
import GUI.BotonCambio;
import GUI.GraficaTemperatura;
import GUI.TiempoSatelital;

public class ApplicationRunner {

	public static void main(String[] args) {
		Simulador s = new Simulador(1,20);
		
		Pantalla appWindow = Pantalla.getInstance();
		TiempoSatelital t = new TiempoSatelital();
		GraficaTemperatura g = new GraficaTemperatura("Temperaturas");
		BotonCambio b = new BotonCambio(s);
		
		s.incluirObservador(appWindow);
		s.incluirObservador(t);
		s.incluirObservador(g);
		s.incluirObservador(b);
		
		appWindow.inicializar(b);
		
		Thread t1 = new Thread(s);
		t1.start();
	}
}
