package ejer1;

import java.util.ArrayList;
import java.util.Random;

import GUI.AppWindow;

public class ApplicationRunner {
		
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	private static int enCabeza(ArrayList<Bicicleta> participantes){
		int enCabeza = 0, max = 0;
		for(int i = 0; i<participantes.size(); i++){
			if(participantes.get(i).getKM() > max){
				max = participantes.get(i).getKM();
				enCabeza = i;
			}
		}
		
		return enCabeza;
	}
	
	public static Runnable empezarCarrera(ArrayList<Bicicleta> participantes, int timeToDeath, AppWindow gui){
		int accidentes, totalParticipantes;
		String tipoCarrera = participantes.get(0).getTipo().toString();
		
		totalParticipantes = participantes.size();
		gui.setParticipantesCarretera(totalParticipantes, totalParticipantes);
		gui.setParticipantesMontana(totalParticipantes, totalParticipantes);
		
		// En la carrera de Carretera se producen 10% de accidentes de entre los participantes
		// en un instante de tiempo X, y en la carrera de Montana se producen el 20%
		if(tipoCarrera == "CARRETERA")
			accidentes = Math.round((participantes.size() * 10)/100);
		else
			accidentes = Math.round((participantes.size() * 20)/100);
		
		// Inicializamos todas las bicicletas
		for(int i = 0; i<participantes.size(); i++)
			participantes.get(i).start();
		
		Runnable r = new Runnable() {
			boolean running = true;
			Integer minutos = 0 , segundos = 0, milesimas = 0;
						
			@Override
			public void run(){
				try {					
					int primero;
		    		while(running) {
		    			Thread.sleep( 4 );
		    		    //Incrementamos 4 milesimas de segundo
		    		    milesimas += 4;		    		   
		    		    
		    		    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
		    		    //y las milesimas de segundo de nuevo a 0
		    		    if( milesimas == 1000 ) {
		    		    	milesimas = 0;
		    		    	segundos++;
		    		    	
			    		    // Actualizamos los segundos de la GUI
			    		    gui.setCrono(segundos);
			    		    
			    		    // Actualizamos quien va en cabeza
		    		    	if(tipoCarrera == "CARRETERA"){
		    		    		primero = enCabeza(participantes);
		    		    		gui.setCarreteraEnCabeza(primero);
		    		    		gui.setCarreteraKM(participantes.get(primero).getKM());
		    		    	}		    		    	
		    		    	else {
		    		    		primero = enCabeza(participantes);
		    		    		gui.setMontanaEnCabeza(primero);
		    		    		gui.setMontanaKM(participantes.get(primero).getKM());
		    		    	}
		    		    	
		    		    	// Generamos el accidente para las bicicletas
		    		    	if (segundos == timeToDeath){
		    		    		for(int i = participantes.size()-accidentes; i<participantes.size(); i++)
		    		    			participantes.remove(i);
		    		    		
		    		    		if(tipoCarrera == "CARRETERA"){
		    		    			gui.setParticipantesCarretera(participantes.size(), totalParticipantes);
		    		    			System.out.println("CARRETERA "+participantes.size()+"/"+totalParticipantes);
		    		    		}
		    		    		else{
		    		    			gui.setParticipantesMontana(participantes.size(), totalParticipantes);
		    		    			System.out.println("MONTANA "+participantes.size()+"/"+totalParticipantes);
		    		    		}
		    		    	}
		    		    	//Si los segundos llegan a 60 entonces aumenta 1 los minutos
		    		    	//y los segundos vuelven a 0
		    		    	else if( segundos == 60 ) {
		    		    		segundos = 0;
		    		    		minutos++;
		    		    		running = false;
		    		    		
		    		    		gui.setCrono("FIN");
		    		    		
		    		    		// Actualizamos el ganador de las respectivas carreras
		    		    		if(tipoCarrera == "CARRETERA")
		    		    			gui.setCarreteraGanador(primero);
		    		    		else
		    		    			gui.setMontanaGanador(primero);
		    		    		
		    		    		// Paramos las bicicletas
		    		    		for(int i = 0; i<participantes.size(); i++)
		    		    			participantes.get(i).parar();
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
		AppWindow gui = new AppWindow();
		
		// El mismo numero de bicicletas para ambas carreras
		int cantidadBicicletas = randInt(1,30);
		
		Carrera carreraCarretera = new FactoriaCarreraCarretera(cantidadBicicletas);
		Carrera carreraMontana = new FactoriaCarreraMontana(cantidadBicicletas);
	
		// Tiempo para que se liberen el 10% y 20% de las bicicletas
		int timeToDeath = randInt(30,60);
	
		// Factoria*.crearCarrera(TC tipo) se encarga de crear los objetos
		ArrayList<Bicicleta> participantesCarretera = carreraCarretera.crearCarrera(TC.CARRETERA);
		ArrayList<Bicicleta> participantesMontana = carreraMontana.crearCarrera(TC.MONTANA);
	
		Runnable c1 = empezarCarrera(participantesCarretera, timeToDeath, gui);
		Runnable c2 = empezarCarrera(participantesMontana , timeToDeath, gui);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}
}
