package controlVelocidad;
public class Freno implements Pedal{
	private boolean _estado;
	private final int desaceleracion=700;
	public static final int ROZAMIENTO=100;
	public Freno() {
		_estado = false;
	}
	public void decremento(int desaceleracion, Eje eje) {	
		eje.incrementarVueltas(-desaceleracion);
	}
	public int actualizarFreno() {
		return desaceleracion + ROZAMIENTO;
	}
	public void soltar() {
		_estado = false;
	}
	public void pisar() {
		_estado = true; 
	}
	public boolean leerEstado() {
		return _estado;
	}
}