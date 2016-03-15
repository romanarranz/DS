package ejer3;

import java.util.ArrayList;
import java.util.Random;

import GUI.AppWindow;

public class ApplicationRunner {
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void main(String [] args){
		ArrayList<Equipo> configuracionEquipo1 = new ArrayList<>();
		ArrayList<Equipo> configuracionEquipo2 = new ArrayList<>();
		ArrayList<Equipo> configuracionEquipo3 = new ArrayList<>();
		
		// Definicion las distintas configuraciones de equipos
		Equipo e1 = new Tarjeta("NVidia GTX 250", 290, 10, 200.0);
		Equipo e2 = new Bus("USB 2.0", 10, 10, 12.0);
		Equipo e3 = new Disco("Seagate 6000", 85, 10, 70.0);
		
		// Añadimos los componentes de la configuracion de equipo
		configuracionEquipo1.add(e1);		
		configuracionEquipo1.add(e3);
		
		configuracionEquipo2.add(e2);
		
		configuracionEquipo3.add(e1);
		configuracionEquipo3.add(e2);
		
		// GUI Singleton
		AppWindow ventana = AppWindow.getInstance();
		
		// Generamos aleatoriamente un tipo de cliente
		Cliente c1 = new Cliente(0, TipoCliente.crear(randInt(0,2)), configuracionEquipo1, ventana);
		Cliente c2 = new Cliente(1, TipoCliente.crear(randInt(0,2)), configuracionEquipo2, ventana);
		Cliente c3 = new Cliente(2, TipoCliente.crear(randInt(0,2)), configuracionEquipo3, ventana);
		Cliente c4 = new Cliente(3, TipoCliente.crear(randInt(0,2)), configuracionEquipo3, ventana);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
