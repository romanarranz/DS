package ejer3;

public class VisitanteNombre extends VisitanteEquipo {
	private String nombre;
	
	VisitanteNombre(){
		nombre = "";
	}
	
	@Override
	public void visitar(Disco d){
		nombre += d.getNombre()+"+";
	}
	
	@Override
	public void visitar(Bus b){
		nombre += b.getNombre()+"+";
	}
	
	@Override
	public void visitar(Tarjeta t){
		nombre += t.getNombre()+"+";
	}
	
	public String getNombre(){
		return nombre;
	}
}
