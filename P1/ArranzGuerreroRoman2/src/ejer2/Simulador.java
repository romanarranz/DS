package ejer2;

import java.util.ArrayList;
import java.util.Random;

public class Simulador extends Observable implements Runnable{
	ArrayList<Integer> temperaturas;
	int temperaturaActual;
	int tMin, tMax;
	boolean running;
	
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
		
		for(int i = tMin; i<tMax; i++)
			temperaturas.add(i);
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
	
	@Override
	public void run(){
		Integer minutos = 0 , segundos = 0, milesimas = 0;
		while (running){
			temperaturaActual = randInt(tMin-1, tMax+1);			
			
			try {
				Thread.sleep( 4 );
    		    //Incrementamos 4 milesimas de segundo
    		    milesimas += 4;
    		    
    		    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
    		    //y las milesimas de segundo de nuevo a 0
    		    if( milesimas == 1000 ) {
    		    	milesimas = 0;
    		    	segundos += 1;
    		    	actualizaTemperaturaMinMax();
    		    	notificar(temperaturaActual);
    		    	
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
