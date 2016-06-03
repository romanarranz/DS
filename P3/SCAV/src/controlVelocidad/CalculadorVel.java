package controlVelocidad;
public class CalculadorVel {
	protected void almacenarVelocidad(int Int_velocidad, Almacenamiento almacena) {
		almacena.almacenarVelocidad(Int_velocidad);
	}
	public int calcularVelocidad(int vueltas, double radio, Almacenamiento almacena) {
		int v = 0;
		v= (int) (vueltas*radio)/40;
		almacena.almacenarVelocidad(v);
		return v;
	}
}