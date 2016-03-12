package ejer2;

public class TiempoSatelital implements Observador{

	public void manejarEvento(int temperaturaActual){
		System.out.println("TiempoSatelital: "+temperaturaActual);
	}
}
