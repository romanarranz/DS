package monitorizacion;
import controlVelocidad.Eje;
public class CalculadorVelMed {
	private double _velMedia;
	private long sumatoria_vel;
	private double sumatoria_gas;
	private double _gastoMedio;
	private double _gastoValorAnterior;
	private int _tiempo_gas, tiempo_vel;
	protected CalculadorVelMed() {
		_velMedia = 0;
		sumatoria_vel = 0;
		sumatoria_gas = 0.0;
		_tiempo_gas = tiempo_vel = 1;
		_gastoValorAnterior = 100.0;
	}
	protected void calcularVelocidadMedia(Eje aEje_e) {
		if(aEje_e.velAnterior != 0){
			if(sumatoria_vel < 1000000000){
				sumatoria_vel += aEje_e.velAnterior;
				_velMedia = sumatoria_vel /tiempo_vel;
				tiempo_vel++;
			}
			else{
				resetearTiempo();
			}
		}
	}
	protected void resetearTiempo() {
		sumatoria_gas = sumatoria_vel = 0;
		_tiempo_gas = tiempo_vel = 1;
	}
	protected double leerVelMedia() {
		return _velMedia;
	}
	public void calcularGastoMedio(Eje aEje_e, Deposito depo) {
		if(aEje_e.velAnterior != 0){
			if(sumatoria_gas < 1000000000){
				if(_gastoValorAnterior - depo.leerNivelActual() > 0){
					sumatoria_gas += _gastoValorAnterior - depo.leerNivelActual();
				}
				_gastoValorAnterior = depo.leerNivelActual();
				_gastoMedio = (sumatoria_gas*100) /_tiempo_gas;
				_tiempo_gas++;
			}
			else{
				resetearTiempo();
			}
		}
	}
	public double leerGastoMedio() {
		return _gastoMedio;
	}
}