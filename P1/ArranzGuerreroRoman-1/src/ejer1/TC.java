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

// Tipo de carrera
public enum TC {
	CARRETERA(0), MONTANA(1);	
	protected int tipo;
	
	TC(int tipo){
		this.tipo = tipo;
	}
	
	public String toString(){
		String msg;
		if(tipo == 0)
			msg = "CARRETERA";
		else
			msg = "MONTANA";
		return msg;
	}
}
