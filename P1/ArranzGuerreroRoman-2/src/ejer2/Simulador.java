/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 2
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package ejer2;

import java.util.ArrayList;
import java.util.Random;

public class Simulador extends Observable implements Runnable{
	private ArrayList<Integer> temperaturas;
	private int temperaturaActual;
	private int tMin, tMax;
	private boolean running;
	private int tRefresco;
	
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	Simulador(int temperaturaMinima, int temperaturaMaxima){
		super();
		running = true;
		tMin = temperaturaMinima;
		tMax = temperaturaMaxima;
		temperaturas = new ArrayList<Integer>();

		// refrescamos cada segundo 
		tRefresco = 1000;
		
		// añadimos todo el intervalo de temperaturas, desde tMin hasta tMax
		for(int i = tMin; i<tMax; i++)
			temperaturas.add(i);
	}
	
	// detener la ejecucion de la hebra
	public void parar(){
		running = false;
	}

	// reanudar la ejecucion de la hebra
	public void comenzar(){
		running = true;
	}

	// realizar una toma de temperaturas cada cuarto de segundo aprox
	public void refrescoMuyRapido(){
		tRefresco = 256;
	}

	// realizar una toma de temperaturas cada medio segundo
	public void refrescoRapido(){
		tRefresco = 500;
	}
	
	// realizar una toma de temperaturas cada segundo
	public void refrescoLento(){
		tRefresco = 1000;
	}
	
	public void actualizaTemperaturaMinMax(){
		if(temperaturaActual > tMax){
			tMax = temperaturaActual;
			temperaturas.remove(0);
			temperaturas.add(tMax);
		}			
		
		if(temperaturaActual < tMin){
			tMin = temperaturaActual;
			temperaturas.remove(temperaturas.size()-1);
			temperaturas.add(0, tMin);
		}
			
		temperaturas.clear();
		for(int i = tMin; i<=tMax; i++)
			temperaturas.add(i);
	}

	// cuerpo de ejecucion de la hebra
	@Override
	public void run(){
		Integer minutos = 0 , segundos = 0, milesimas = 0;
		while (running){
			// nueva toma de temperatura, aleatoria entre grado arriba y grado abajo 
			temperaturaActual = randInt(tMin-1, tMax+1);			
			
			try {
				Thread.sleep( 4 );
    		    //Incrementamos 4 milesimas de segundo
    		    milesimas += 4;
    		    
    		    // Cada vez que transcurra el tiempo de refresco
    		    if(milesimas%tRefresco == 0){
		    		actualizaTemperaturaMinMax();
		    		notificar(temperaturaActual);
		    	}
    		    
    		    //Cuando llega a 1000 osea 1 segundo aumentamos 1 segundo y las milesimas de segundo de nuevo a 0
    		    if( milesimas == 1000 ) {    		    	    		   
    		    	
    		    	milesimas = 0;
    		    	segundos += 1;    		    	
    		    	
    		    	if( segundos == 60 ) {
    		    		segundos = 0;
    		    		minutos++;
    		    		running = false;   		    	
    		    	}    		    	
    		    }	
			}
			catch(java.lang.InterruptedException e){
				e.printStackTrace();
			}			
		}
				
	}
	
	public int getTemperaturaActual(){
		return temperaturaActual;
	}
}
