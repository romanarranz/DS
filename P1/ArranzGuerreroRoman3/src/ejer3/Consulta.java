package ejer3;

public class Consulta implements Runnable{
	private Equipo equipo;
	private VisitanteNombre visitor;
	
	Consulta(Equipo e, VisitanteNombre vn){
		equipo = e;
		visitor = vn;
	}
	
	@Override
	public void run(){ 
		equipo.aceptar(visitor);
		System.out.println(visitor.getNombre());
		Cliente.endThreadCounter++;
	}
}
