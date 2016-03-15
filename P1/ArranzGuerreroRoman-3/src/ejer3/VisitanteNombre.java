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

// Visitante concreto que obtiene los nombres de los productos visitables
public class VisitanteNombre extends VisitanteEquipo {
	private String nombre;
	
	VisitanteNombre(){
		nombre = "";
	}
	
	@Override
	public void visitar(Disco d){
		nombre += d.getNombre()+"+";
	}
	
	@Override
	public void visitar(Bus b){
		nombre += b.getNombre()+"+";
	}
	
	@Override
	public void visitar(Tarjeta t){
		nombre += t.getNombre()+"+";
	}
	
	public String getNombre(){
		return nombre;
	}
}
