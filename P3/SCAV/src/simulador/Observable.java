package simulador;

public abstract class Observable {	
	public Observador o;
	
	public Observable() {
		o = null;
	}
	
	public void insertar(Observador o) {
		this.o = o;
	}
	
	public void eliminar(){
		o = null;
	}
	
	public void notificarObservador() {
		o.actualizar();
	}
}