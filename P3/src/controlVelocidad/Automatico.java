package controlVelocidad;
public class Automatico {	
	public void mantenerVelocidad(Acelerador aAcelerador_a, Freno freno, Almacenamiento aAlmacenamiento_al, Eje eje) {		
		if(aAlmacenamiento_al.leerVelocidad() > aAlmacenamiento_al.leerVelSeleccionada()){
			freno.decremento(300, eje); 
		}
		if(aAlmacenamiento_al.leerVelocidad() < aAlmacenamiento_al.leerVelSeleccionada()){
			aAcelerador_a.incrementar(300, eje); 
		}
		if(aAlmacenamiento_al.leerVelocidad() == aAlmacenamiento_al.leerVelSeleccionada()){
			aAcelerador_a.incrementar(0, eje);
		}
	}

}