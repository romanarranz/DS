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

public class Distancia implements Filtro {
	
	private double d;
	private double diametro;
	private int tiempo;
	
	public Distancia() {
		
		// distancia
		d = 0;
		
		// Diametro 60 cm
		diametro = 60;
		
		// dejamos pasar 5s para calcular distancia recorrida
		tiempo = 5;
	}

	@Override
	public double ejecutar(Object o) {
		
		double velocidadAngular = (2 * Math.PI * (double) o) / 60;

		// metros/segundo
		double velocidad = (velocidadAngular * (diametro/100));
		
		// distancia
		d = velocidad*tiempo;
		
		return d;
	}

	@Override
	public String toString(Object o) {
		
		return "Se ha recorrido en 5s: "+ejecutar(o)+"metros";
	}

}
