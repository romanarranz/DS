package ejer1;

public class FactoriaManillarMontana implements FactoriaManillar{
	public Manillar crearManillar(){
		return new ManillarMontana();
	}
}
