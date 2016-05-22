package monitorizacion;
import controlVelocidad.Eje;
public class Reseteo {
		protected void inicializarValores(CalculadorVelMed velMed, Eje eje) {
		eje.resetear();
		velMed.resetearTiempo();
	}
}