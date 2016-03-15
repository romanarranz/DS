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

import java.util.ArrayList;

// Factoria abstracta general de Carreras
public abstract class FactoriaCarrera implements Carrera{
	public abstract ArrayList<Bicicleta> crearCarrera(TC tipo);
}
