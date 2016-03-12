package ejer3;

public class Bus extends Equipo{
	private double precioNeto, precioConDescuento, potencia;
	
	Bus(String nombre, double precioNeto, int descuento, double potencia){
		super(nombre);
		this.potencia = potencia;
		this.precioNeto = precioNeto;
		this.precioConDescuento = precioNeto - (descuento/100.0)*precioNeto;
	}
	
	@Override
	public void aceptar(VisitanteEquipo ve){
		ve.visitar(this);
	}
	
	@Override
	public double getPrecioNeto(){
		return precioNeto;
	}
	
	@Override
	public double getPrecioConDescuento(){
		return precioConDescuento;
	}
	
	@Override
	public double getPotencia(){
		return potencia;
	}
	
	public void setDescuento(int descuento){
		precioConDescuento = precioConDescuento - (descuento/100)*precioConDescuento; 
	}
}
