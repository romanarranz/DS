/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 1
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package ejer1;

// Producto Bicicleta especifica
public class BicicletaCarretera extends Bicicleta{
	BicicletaCarretera(TC tipo, Manillar m, Cuadro c, Ruedas r, int numeroCorredor){
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
