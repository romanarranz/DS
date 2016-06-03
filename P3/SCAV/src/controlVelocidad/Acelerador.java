package controlVelocidad;
public class Acelerador implements Pedal{
	private boolean _estado;
	private final int aceleracion=300;
	public static final int ROZAMIENTO=100;
	public Acelerador() {
		_estado = false;
	}
	public void incrementar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion);
	}
	public double actualizarAcelerador(double velAnterior) {
		return (aceleracion - (ROZAMIENTO*0.015*velAnterior));
	}
	public void soltar() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void pisar() {
		_estado = true;
	}
}