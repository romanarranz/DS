package ejer2;

public class GraficaTemperatura implements Observador{
	
	public void manejarEvento(int temperaturaActual){
		System.out.println("GraficaTemperatura: "+temperaturaActual);
	}
}
