package ejer2;

public class BotonCambio implements Observador{

	public void manejarEvento(int temperaturaActual){
		System.out.println("BotonCambio: "+temperaturaActual);
	}
}
