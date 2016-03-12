package ejer3;

import java.util.Random;

import GUI.AppWindow;

public class ApplicationRunner {
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void main(String [] args){
		// Definicion las distintas configuraciones de equipos
		Equipo e = new Tarjeta("NVidia GTX 250", 290, 10, 200.0);
		Equipo e2 = new Bus("USB 2.0", 10, 10, 12.0);
		Equipo e3 = new Disco("Seagate 6000", 120, 10, 70.0);
		
		// Generamos aleatoriamente un tipo de cliente
		Cliente c = new Cliente(TipoCliente.crear(randInt(0,2)), e, new VisitanteNombre());
		c.runTests();
		
		AppWindow ventana = new AppWindow();
		ventana.setDato(0,2,"ROMAN");
	}
}
