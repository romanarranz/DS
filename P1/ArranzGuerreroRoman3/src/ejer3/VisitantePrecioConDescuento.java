package ejer3;

public class VisitantePrecioConDescuento extends VisitanteEquipo{
	double precio;
	
	@Override
	public void visitar(Disco d){
		precio = d.getPrecioConDescuento();
	}
	
	@Override
	public void visitar(Bus b){
		precio = b.getPrecioConDescuento();
	}
	
	@Override
	public void visitar(Tarjeta t){
		precio = t.getPrecioConDescuento();
	}
	
	public double getPrecio(){
		return precio;
	}
}
