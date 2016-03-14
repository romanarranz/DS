package ejer1;

public class BicicletaMontana extends Bicicleta{
	BicicletaMontana(TC tipo, Manillar m, Cuadro c, Ruedas r, int numeroCorredor){
		super(tipo, m, c, r, numeroCorredor);
	}
	
	@Override
	public TC getTipo() {
		return this.tipo;
	}

	@Override
	public void setTipo(TC tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString(){
		return "Bicicleta de Carretera se compone de "+m.toString()+", "+c.toString()+", "+r.toString();
	}
}
