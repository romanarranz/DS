package ejer3;

public abstract class Equipo {
	private String nombre;
	
	public Equipo(String nombre){
	    this.nombre= nombre; 
	}
	
	public String getNombre(){
	    return nombre;
	}
	
	public abstract double getPotencia();	
	public abstract double getPrecioNeto();
	public abstract double getPrecioConDescuento();
	public abstract void aceptar(VisitanteEquipo ve);
}
