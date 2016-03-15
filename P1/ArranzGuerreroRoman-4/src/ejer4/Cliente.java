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

public class Cliente {
	
	private Despachador despachador;
	
	public Cliente() {		
		despachador = null;
	}
	
	public void setDespachador(Despachador d) {		
		despachador = d;
	}
	
	public void solicitar(double peticion) {		
		despachador.solicitarFiltro(peticion);
	}

}
