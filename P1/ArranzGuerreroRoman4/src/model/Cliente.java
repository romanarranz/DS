package model;

public class Cliente {
	
	private Despachador despachador;
	
	public Cliente() {		
		despachador = null;
	}
	
	public void setDespachador(Despachador d) {		
		despachador = d;
	}
	
	public void solicitar(double peticion) {		
		despachador.filtroPeticion(peticion);
	}

}
