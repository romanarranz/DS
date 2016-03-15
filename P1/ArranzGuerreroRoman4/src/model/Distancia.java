package model;

public class Distancia implements Filtro {
	
	private double d;
	private double diametro;
	private int tiempo;
	
	public Distancia() {
		
		d = 0;
		
		// Diametro 60 cm
		diametro = 60;
		
		// sup 5s en ho para calcular distancia recorrida
		tiempo = 5;
	}

	@Override
	public double ejecutar(Object o) {
		
		double angularSpeed = (2 * Math.PI * (double) o) / 60;
		
		double speed = (angularSpeed * (diametro/100));		// Velocidad en m/s
		
		d = speed * tiempo;
		
		return d;
	}

	@Override
	public String toString(Object o) {
		
		return "Traveled distance in 5 seg: " + ejecutar(o) + "m.";
	}

}
