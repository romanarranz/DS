package ejer1;

import java.util.ArrayList;
import java.util.Random;

public class ApplicationRunner {
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static Runnable empezarCarrera(ArrayList<Bicicleta> participantes, int timeToDeath){
		int accidentes;
		String tipoCarrera = participantes.get(0).getTipo().toString();
		
		if(tipoCarrera == "CARRETERA")
			accidentes = Math.round((participantes.size() * 10)/100);
		else
			accidentes = Math.round((participantes.size() * 20)/100);
		
		Runnable r = new Runnable() {
			boolean running = true;
			Integer minutos = 0 , segundos = 0, milesimas = 0;
						
			@Override
			public void run(){
				System.out.println("COMIENZA carrera de "+tipoCarrera);
				try {
		    		while(running) {
		    			Thread.sleep( 4 );
		    		    //Incrementamos 4 milesimas de segundo
		    		    milesimas += 4;
		    		    
		    		    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
		    		    //y las milesimas de segundo de nuevo a 0
		    		    if( milesimas == 1000 ) {
		    		    	milesimas = 0;
		    		    	segundos += 1;
		    		    	
		    		    	System.out.println(tipoCarrera+" "+segundos+"s");
		    		    	
		    		    	// Generamos el accidente para las bicicletas
		    		    	if (segundos == timeToDeath){
		    		    		for(int i = participantes.size()-accidentes; i<participantes.size(); i++)
		    		    			participantes.remove(i);
		    		    		System.out.println("Se han accidentado "+accidentes+" bicicletas");
		    		    	}
		    		    	//Si los segundos llegan a 60 entonces aumenta 1 los minutos
		    		    	//y los segundos vuelven a 0
		    		    	else if( segundos == 60 ) {
		    		    		segundos = 0;
		    		    		minutos++;
		    		    		running = false;
		    		    		System.out.println("TERMINA carrera de "+tipoCarrera);
		    		    	}    		    	
		    		    }		    			
		    		}
		    	} catch(Exception e) {
		    		e.getStackTrace();
		    	}
			}
		};
		
		return r;
	}
	
	public static void main(String[] args) {
		System.out.print("-- Comienzan las carreras --\n");
		
		// El mismo numero de bicicletas para ambas carreras
		int cantidadBicicletas = randInt(1,100);
		
		Carrera carreraCarretera = new FactoriaCarreraCarretera(cantidadBicicletas);
		Carrera carreraMontana = new FactoriaCarreraMontana(cantidadBicicletas);
	
		// Tiempo para que se liberen el 10% y 20% de las bicicletas
		int timeToDeath = randInt(30,60);
		
		// Factoria*.crearCarrera(TC tipo) se encarga de crear los objetos
		Runnable c1 = empezarCarrera(carreraCarretera.crearCarrera(TC.CARRETERA), timeToDeath);
		Runnable c2 = empezarCarrera(carreraMontana.crearCarrera(TC.MONTANA) , timeToDeath);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}
}
