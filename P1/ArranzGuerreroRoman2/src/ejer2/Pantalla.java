package ejer2;

import GUI.AppWindow;

public class Pantalla implements Observador{
	
	int temperaturaActual;
	private AppWindow ventana; 
	
	Pantalla(AppWindow d){
		ventana = d;
	}
	
	public void manejarEvento(int temperaturaActual){
		this.temperaturaActual = temperaturaActual;
		refrescarPantalla();
	}
	
	private void refrescarPantalla(){
		System.out.println("Pantalla: "+temperaturaActual);
		ventana.setTemperaturaActual(temperaturaActual);
	}
}
