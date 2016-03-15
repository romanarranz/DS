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

// Equipo como elemento abstracto visitable que tiene el metodo aceptar
public abstract class Equipo {
	private String nombre;
	
	public Equipo(String nombre){
	    this.nombre= nombre; 
	}
	
	public String getNombre(){
	    return nombre;
	}
	
	public abstract double getPotencia();	
	public abstract double getPrecioNeto();
	public abstract double getPrecioConDescuento();
	public abstract void aceptar(VisitanteEquipo ve);
}
