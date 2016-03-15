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

// Disco como elemento visitable concreto
public class Disco extends Equipo{
	private double precioNeto, precioConDescuento, potencia;
	
	Disco(String nombre, double precioNeto, int descuento, double potencia){
		super(nombre);
		this.potencia = potencia;
		this.precioNeto = precioNeto;
		this.precioConDescuento = precioNeto - (descuento/100.0)*precioNeto;
	}
	
	@Override
	public void aceptar(VisitanteEquipo ve){
		ve.visitar(this);
	}
	
	@Override
	public double getPrecioNeto(){
		return precioNeto;
	}
	
	@Override
	public double getPrecioConDescuento(){
		return precioConDescuento;
	}
	
	@Override
	public double getPotencia(){
		return potencia;
	}
	
	public void setDescuento(int descuento){
		precioConDescuento = precioConDescuento - (descuento/100)*precioConDescuento; 
	}
}
