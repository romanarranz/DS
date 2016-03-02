package ejer1;

public abstract class Bicicleta {
	protected TC tipo = null;
	protected Manillar m;
	protected Ruedas r;
	protected Cuadro c;
	
	Bicicleta(TC tipo, Manillar m, Cuadro c, Ruedas r){
		this.tipo = tipo;
		this.m = m;
		this.c = c;
		this.r = r;
	}
	
	public abstract String toString();
	public abstract TC getTipo();
	public abstract void setTipo(TC tipo);
}
