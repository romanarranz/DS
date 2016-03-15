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

import GUI.AppWindow;

public class Despachador {
	
	private CambioFiltro filterChain;
	
	public Despachador(AppWindow ui) {
		
		filterChain = new CambioFiltro();
		filterChain.setObjetivo(ui);
	}
	
	public void setFiltro(Filtro f) {
		
		filterChain.anadirFiltro(f);
	}

	public void filtroPeticion(double petition) {
		
		filterChain.ejecutar(petition);
	}

}
