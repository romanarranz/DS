package ejer2;

import GUI.AppWindow;

public class Pantalla implements Observador{
	
	int temperaturaActual;
	private AppWindow ventana;
	
	Pantalla(AppWindow d){
		temperaturaActual = 0;
		ventana = d;
	}
	
	public void manejarEvento(int temperaturaActual){
		this.temperaturaActual = temperaturaActual;
		refrescarPantalla();
	}
	
	private void refrescarPantalla(){
		ventana.setTemperaturaActual(temperaturaActual);
	}
}
