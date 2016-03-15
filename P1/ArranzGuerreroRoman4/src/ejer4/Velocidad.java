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

public class Velocidad implements Filtro {
	
	private double v;
	private double diametro;
	
	public Velocidad() {
		
		// velocidad
		v = 0;

		// rueda con diametro 60cm
		diametro = 60;
	}

	@Override
	public double ejecutar(Object o) {
		
		double angularSpeed = (2 * Math.PI * (double) o) / 60;
		
		// velocidad
		v = (angularSpeed*(diametro/100)) * (3600.0/1000.0);
		
		return v;
	}

	@Override
	public String toString(Object o) {
		
		return "Velocidad: "+ejecutar(o)+"km/h";
	}

}
