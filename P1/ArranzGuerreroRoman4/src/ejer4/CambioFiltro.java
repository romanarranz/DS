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

import java.util.ArrayList;
import GUI.AppWindow;

public class CambioFiltro {
	
	private ArrayList<Filtro> filtros;
	private AppWindow ventana;
	
	public CambioFiltro() {
		filtros = new ArrayList<Filtro>();
	}
	
	public void setObjetivo(AppWindow d) {
		ventana = d;
	}
	
	public void anadirFiltro(Filtro f) {
		filtros.add(f);
	}

	public void ejecutar(double peticion) {
		
		for(int i = 0; i<filtros.size(); i++)
			// Llamamos a toString de los filtros para que muestre por pantalla el resultado de la ejecución de cada filtro
			System.out.println(filtros.get(i).toString(peticion));		
		
		ventana.ejecutar(peticion);
	}

}
