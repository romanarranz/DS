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
	
	private CambioFiltro cambiador;
	
	public Despachador(AppWindow ui) {
		cambiador = new CambioFiltro();
		cambiador.setObjetivo(ui);
	}
	
	public void setFiltro(Filtro f) {
		cambiador.anadirFiltro(f);
	}

	public void solicitarFiltro(double petition) {
		cambiador.ejecutar(petition);
	}

}
