package ejer2;

import java.util.ArrayList;

public abstract class Observable {
	ArrayList<Observador> observadores;
	
	protected Observable(){
		observadores = new ArrayList<>();
	}
	
	public void incluirObservador (Observador o){
		observadores.add(o);
	}
	
	public void eliminarObservador (Observador o){
		observadores.remove(o);
	}
	
	public void notificar(int temperaturaActual){
		for(Observador o : observadores){
			o.manejarEvento(temperaturaActual);
		}
	}
}
