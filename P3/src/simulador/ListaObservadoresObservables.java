package simulador;

import java.util.ArrayList;
import java.util.List;

public class ListaObservadoresObservables {

	private List<Observador> observadores;
	
	public ListaObservadoresObservables(){
		observadores = new ArrayList<>();
	}
	
	public void incluir(Observador o){
		observadores.add(o);
	}
	
	public void eliminar(Observador o){
		observadores.remove(o);
	}
	
	public List<Observador> getObservadores(){
		return observadores;
	}
}
