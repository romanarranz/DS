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
	
	public void manejarEvento(int temperaturaActual){
		this.temperaturaActual = temperaturaActual;		
		refrescarGrafica();
	}
	
	private void refrescarGrafica(){
		ventana.setTemperaturaActual(this.temperaturaActual);
	}
}
