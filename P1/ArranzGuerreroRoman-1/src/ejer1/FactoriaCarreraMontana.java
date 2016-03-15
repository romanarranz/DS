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

// Factoria especifica de carrera
public class FactoriaCarreraMontana implements Carrera{
	
	private int cantidadBicicletas;
	private FactoriaCuadro fc;
	private FactoriaManillar fm;
	private FactoriaRuedas fr;
	
	public FactoriaCarreraMontana(int n){
		cantidadBicicletas = n;
		
		// seleccionamos las factorias especificas de nuestros productos
		fc = new FactoriaCuadroCarretera();
		fm = new FactoriaManillarCarretera();
		fr = new FactoriaRuedasCarretera();
	}

	@Override
	public ArrayList<Bicicleta> crearCarrera(TC tipo){
		ArrayList<Bicicleta> participantes = new ArrayList<>();
		
		for(int i = 0; i<cantidadBicicletas; i++){
			
			// llamamos a los metodos de creacion de cada factoria especifica
			Cuadro c = fc.crearCuadro();
			Manillar m = fm.crearManillar();
			Ruedas r = fr.crearRuedas();
			
			BicicletaCarretera b = new BicicletaCarretera(tipo, m, c, r, i+1);
			participantes.add(b);
		}

		return participantes;
	}
}