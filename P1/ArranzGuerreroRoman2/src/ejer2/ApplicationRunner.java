package ejer2;

import GUI.AppWindow;

public class ApplicationRunner {

	public static void main(String[] args) {
		AppWindow appWindow = AppWindow.getInstance();
		
		Pantalla p = new Pantalla(appWindow);
		TiempoSatelital t = new TiempoSatelital();
		GraficaTemperatura g = new GraficaTemperatura(appWindow);
		BotonCambio b = new BotonCambio(appWindow);
		
		// Vamos a suponer que nos encontramos en EUW/España en Verano
		// Si no tendriamos que hacer un selector de region y pais		
		Simulador s = new Simulador(30,39);
		s.incluirObservador(p);
		s.incluirObservador(t);
		s.incluirObservador(g);
		s.incluirObservador(b);
		
		Thread t1 = new Thread(s);
		t1.start();
	}
}
