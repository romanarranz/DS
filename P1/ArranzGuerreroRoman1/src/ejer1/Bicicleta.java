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

// Producto Bicicleta general, que se compone de forma general de manillar ruedas y cuadro
public abstract class Bicicleta extends Thread{
	protected TC tipo = null;
	protected Manillar m;
	protected Ruedas r;
	protected Cuadro c;
	
	protected int km, numeroCorredor;
	protected boolean running;
	
	Bicicleta(TC tipo, Manillar m, Cuadro c, Ruedas r, int numeroCorredor){
		this.tipo = tipo;
		this.m = m;
		this.c = c;
		this.r = r;
		this.km = 0;
		this.numeroCorredor = numeroCorredor;
		this.running = true;
	}
	
	public abstract String toString();
	public abstract TC getTipo();
	public abstract void setTipo(TC tipo);
	
	public int getKM(){
		return km;
	}
	
	// detener la ejecucion de la hebra
	public void parar(){
		running = false;
	}
	
	// cuerpo de ejecucion de la hebra
	@Override
	public void run(){
		try {
			while(running){
				// parar la hebra aleatoriamente
				Thread.sleep((long) ((Math.random()*1)*1000));
				km++;
			}
		} catch(Exception e) {
    		e.getStackTrace();
    	}
	}
}
