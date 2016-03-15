/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 3
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

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
	
	@Override
	public String toString(){
		String s;
		switch(tipo){
			case 0:
				s= "CLIENTEREGULAR"; 
				break;
			case 1:
				s = "CLIENTEVIP";
				break;
			default:
				s = "CLIENTEMAYORISTA";
		}
		return s;
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
