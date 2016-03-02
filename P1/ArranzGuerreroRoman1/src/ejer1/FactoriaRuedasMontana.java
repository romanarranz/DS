package ejer1;

public class FactoriaRuedasMontana implements FactoriaRuedas{
	public Ruedas crearRuedas(){
		return new RuedasMontana();
	}
}
