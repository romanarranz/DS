package ejer3;

public enum TipoCliente {
	CLIENTEREGULAR(0),CLIENTEVIP(1),CLIENTEMAYORISTA(2);
	
	protected int tipo;
	
	TipoCliente(int tipo){
		this.tipo = tipo;
	}
	
	protected int getTipo(){
		return tipo;
	}
	
	public static TipoCliente crear(int tipo){
		TipoCliente tc = null;
		switch(tipo){
			case 0:
				tc = CLIENTEREGULAR; 
				break;
			case 1:
				tc = CLIENTEVIP;
				break;
			default:
				tc = CLIENTEMAYORISTA;
		}
		return tc;
	}
}
