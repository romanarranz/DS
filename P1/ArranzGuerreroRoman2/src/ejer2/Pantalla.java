package ejer2;

import GUI.Display;

public class Pantalla implements Observador{
	
	int temperaturaActual;
	private Display ventana; 
	
	Pantalla(Display d){
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
