package monitorizacion;
import controlVelocidad.Eje;
public class Reseteo {
	public void inicializarValores(CalculadorVelMed velMed, Eje eje) {
		eje.resetear();
		velMed.resetearTiempo();
	}
}