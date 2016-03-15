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

// Visitante concreto que obtiene los precios netos de los productos visitables
public class VisitantePrecio extends VisitanteEquipo{
	private double precio;
	
	VisitantePrecio(){
		precio = 0;
	}
	
	@Override
	public void visitar(Disco d){
		precio += d.getPrecioNeto();
	}
	
	@Override
	public void visitar(Bus b){
		precio += b.getPrecioNeto();
	}
	
	@Override
	public void visitar(Tarjeta t){
		precio += t.getPrecioNeto();
	}
	
	public double getPrecio(){
		return precio;
	}
}
