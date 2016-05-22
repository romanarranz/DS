package monitorizacion;

import controlVelocidad.Eje;
public final class Deposito {
	private double _nivelActual;
	private final double NIVEL_INICIAL = 100;
	private final double RATIO_CONUSMO = 0.0000000005;
	public Deposito() {
		_nivelActual = NIVEL_INICIAL;
	}
	public double leerNivelActual() {
		return _nivelActual;
	}
	public double leerNivelInicial() {
		return NIVEL_INICIAL;
	}
	public void actualizarDeposito(Eje Eje_e) {
		int rev = Eje_e.leerRevoluciones();
		_nivelActual -= (rev*(rev/15))*RATIO_CONUSMO;
		if(_nivelActual <= 0){
			_nivelActual = 0;
		}
	}
	public void cambiarANivelInicial() {
		_nivelActual = NIVEL_INICIAL;
	}
}