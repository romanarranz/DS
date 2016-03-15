/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 3
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package ejer3;

// Visitante general
public abstract class VisitanteEquipo {
	public abstract void visitar(Disco d);
	public abstract void visitar(Tarjeta t);
	public abstract void visitar(Bus b);
}
