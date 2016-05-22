package simulador;

public abstract class Observable {	
	public ListaObservadoresObservables lObservadores;
	
	public Observable() {
		lObservadores = new ListaObservadoresObservables();
	}
	public void agregarObservador(Observador o) {
		lObservadores.incluir(o);
	}
	public void eliminarObservador(Observador o) {
		lObservadores.eliminar(o);
	}
	public void notificarObservadores() {
		for (Observador o : lObservadores.getObservadores()) {
			o.actualizar();
	    }
	}
}