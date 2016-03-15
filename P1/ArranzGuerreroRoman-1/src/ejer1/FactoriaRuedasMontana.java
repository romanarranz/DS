/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 1
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package ejer1;

// Factoria especifica de ruedas
public class FactoriaRuedasMontana implements FactoriaRuedas{
	public Ruedas crearRuedas(){
		return new RuedasMontana();
	}
}
