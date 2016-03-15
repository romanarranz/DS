package model;

public class Velocidad implements Filtro {
	
	private double v;
	private double diametro;
	
	public Velocidad() {
		
		v = 0;
		diametro = 60;		// Suponemos que la rueda tiene un diámetro de 60 cm
	}

	@Override
	public double ejecutar(Object o) {
		
		double angularSpeed = (2 * Math.PI * (double) o) / 60;
		
		v = (angularSpeed * (diametro/100)) * (3600.0/1000.0);
		
		return v;
	}

	@Override
	public String toString(Object o) {
		
		return "Speed: " + ejecutar(o) + "km/h.";
	}

}
