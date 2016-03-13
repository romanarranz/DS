package ejer2;

import java.util.Random;
import GUI.AppWindow;

public class GraficaTemperatura implements Observador{
	int temperaturaActual;
	private AppWindow ventana;
	
	public GraficaTemperatura(AppWindow d){
		temperaturaActual = 0;			
		ventana = d;
	}
	
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public static int randomTemperatura() {
	    return randInt(20,40);
	}
	
	public void manejarEvento(int temperaturaActual){
		this.temperaturaActual = temperaturaActual;		
		refrescarGrafica();
	}
	
	private void refrescarGrafica(){
		ventana.setTemperaturaActual(this.temperaturaActual);
	}
}
