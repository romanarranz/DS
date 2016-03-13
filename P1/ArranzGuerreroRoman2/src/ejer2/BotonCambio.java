package ejer2;

import GUI.AppWindow;

/*
 * 
 * habria que pasar la clase al paquete de GUI y que fuera un JButton 
 */
public class BotonCambio implements Observador{

	int temperaturaActual;
	private AppWindow ventana;
	
	BotonCambio(AppWindow d){
		temperaturaActual = 0;
		ventana = d;
	}
	
	public void manejarEvento(int temperaturaActual){
		//System.out.println("BotonCambio: "+temperaturaActual);
	}
	
	private void refrescarPantalla(){
		ventana.setTemperaturaActual(temperaturaActual);
	}
}
