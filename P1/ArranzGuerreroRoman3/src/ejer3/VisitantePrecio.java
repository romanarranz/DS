package ejer3;

public class VisitantePrecio extends VisitanteEquipo{
	private double precio;
	
	VisitantePrecio(){
		precio = 0;
	}
	
	@Override
	public void visitar(Disco d){
		precio += d.getPrecioNeto();
	}
	
	@Override
	public void visitar(Bus b){
		precio += b.getPrecioNeto();
	}
	
	@Override
	public void visitar(Tarjeta t){
		precio += t.getPrecioNeto();
	}
	
	public double getPrecio(){
		return precio;
	}
}
