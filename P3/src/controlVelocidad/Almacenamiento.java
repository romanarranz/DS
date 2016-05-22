package controlVelocidad;
public class Almacenamiento {
	private int velocidad;
	private double distancia;
	private int _seleccionada;
	public Almacenamiento() {
		velocidad = 0;
		distancia = 0.0;
		_seleccionada = 0;
	}
	synchronized public void almacenarVelocidad(int aInt_velActual) {
		velocidad=aInt_velActual;
		almacenarDistancia();
	}
	synchronized public int leerVelocidad() {
		return velocidad;	
	}
	synchronized public void almacenarDistancia() {
		if(velocidad*0.25 > 1){
			distancia += (velocidad*0.25)/(3600); 
		}		
	}
	synchronized public double leerDistancia() {
		return distancia;	
	}
	synchronized public void almacenarVelSeleccionada() {
		_seleccionada = velocidad;
	}
	synchronized public int leerVelSeleccionada() {
		return _seleccionada;
	}
}