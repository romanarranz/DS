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

// Visitante concreto que obtiene los precios con descuento de los productos visitables
public class VisitantePrecioConDescuento extends VisitanteEquipo{
	private double precio;
	
	VisitantePrecioConDescuento(){
		precio = 0;
	}
	
	@Override
	public void visitar(Disco d){
		precio += d.getPrecioConDescuento();
	}
	
	@Override
	public void visitar(Bus b){
		precio += b.getPrecioConDescuento();
	}
	
	@Override
	public void visitar(Tarjeta t){
		precio += t.getPrecioConDescuento();
	}
	
	public double getPrecio(){
		return precio;
	}
}
