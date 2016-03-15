/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 4
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package ejer4;

import java.util.Random;

public class Deposito implements Filtro {
	
	private double d;
	
	public Deposito() {
		d = 0;
	}

	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	@Override
	public double ejecutar(Object o) {
		
		Double aux = (Double) o;
		Integer auxI = aux.intValue();
		
		int depAux = randInt(0, auxI);
		
		if(depAux > (auxI/2))
			d = 1.0;
		else if(depAux > (auxI/4))
			d = 2.0;
		else
			d = 0.0;
		
		return d;
	}

	@Override
	public String toString(Object o) {
				
		String msg = "Deposito: ";
		double dep = ejecutar(o);
		
		if(dep == 0.0)
			msg += "Vacio";
		else if(dep == 1.0)
			msg += "Lleno";
		else
			msg += "Medio deposito";

		return msg;
	}
}
