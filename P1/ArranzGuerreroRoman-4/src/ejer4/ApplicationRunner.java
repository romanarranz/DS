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

public class ApplicationRunner {

	public static void main(String[] args) {
		
		AppWindow appWindow = AppWindow.getInstance();
		
		Despachador d = new Despachador(appWindow);
		
		Filtro fVelocidad = new Velocidad();
		Filtro fDistancia = new Distancia();
		Filtro fDeposito = new Deposito();
				
		d.setFiltro(fVelocidad);
		d.setFiltro(fDistancia);
		d.setFiltro(fDeposito);
		
		Cliente client = new Cliente();
		client.setDespachador(d);		
		client.solicitar(500);
	}

}
