package simulador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListaObservadoresObservables extends Observable {

	private List<Observador> observadores;
	public Map<Observador, List<Object>> eventosProducidos;
	
	public ListaObservadoresObservables(){
		observadores = new ArrayList<>();
		eventosProducidos = new LinkedHashMap<Observador, List<Object>>();
	}
	
	public void incluir(Observador o){
		observadores.add(o);
		eventosProducidos.put(o, new ArrayList<>());
	}
	
	public void eliminar(Observador o){
		observadores.remove(o);
		eventosProducidos.remove(o);
	}
	
	public List<Observador> getObservadores(){
		return observadores;
	}
	
	public void notificarObservadores(){
		for(Observador o : observadores){
			o.actualizar();
		}
	}
	
	public Map<Observador, List<Object>> getEventosProducidos(){
		return eventosProducidos;
	}
}
