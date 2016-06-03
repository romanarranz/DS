package controlVelocidad;
public class Motor {
	private boolean _estado;
	public Motor() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void cambiarEstado() {
		if(_estado == false){
			_estado = true;
		}
		else{
			_estado = false;
		}
	}
}