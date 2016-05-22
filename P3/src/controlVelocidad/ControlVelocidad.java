package controlVelocidad;
public class ControlVelocidad {
	public Acelerador acelera;
	public Almacenamiento almacena;
	public Eje eje;
	public Freno freno;
	public Motor motor;
	public Palanca estadoPalanca;
	private Reloj reloj;
	private Automatico automatico;
	public ControlVelocidad() {
		acelera = new Acelerador();
		almacena = new Almacenamiento();
		automatico = new Automatico();
		eje = new Eje();
		freno = new Freno();
		motor = new Motor();
		estadoPalanca = new Palanca();
		reloj = new Reloj(this);
	}
	public void start(){
		reloj.start();
	}
	public void controlarEstado() {
		int incremento=0, decremento=0;

		if(motor.leerEstado()){
			if(estadoPalanca.leerEstado() == Palanca.APAGADO){
				if(acelera.leerEstado()){
					incremento = (int) acelera.actualizarAcelerador(eje.velAnterior);
					acelera.incrementar(incremento, eje);
					calcularVelocidad();
				}
				if(freno.leerEstado()){
					decremento = (int) freno.actualizarFreno();
					freno.decremento(decremento, eje);
					calcularVelocidad();
				}
				if(!acelera.leerEstado() && !freno.leerEstado()){
					freno.decremento(Freno.ROZAMIENTO, eje);
					calcularVelocidad();
				}
			}
			if(estadoPalanca.leerEstado() == Palanca.MANTENIENDO){
				almacena.almacenarVelSeleccionada();
				automatico.mantenerVelocidad(acelera, freno,almacena, eje);
				calcularVelocidad();
			}
			if(estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				automatico.mantenerVelocidad(acelera, freno, almacena, eje);
				calcularVelocidad();				
			}
		}
		else{
			if(freno.leerEstado()){
				decremento = (int) freno.actualizarFreno();
				freno.decremento(decremento, eje);
				calcularVelocidad();
			}
			freno.decremento(Freno.ROZAMIENTO, eje);
			calcularVelocidad();
		}
	}
	public void cambiarPalanca(int aInt_estado) {
		estadoPalanca.cambiarEstado(aInt_estado);
	}
	public int obtenerVel(){
		return almacena.leerVelocidad();		
	}
	public double obtenerDist(){
		return almacena.leerDistancia();
	}
	public int obtenerRev(){
		return eje.leerRevoluciones();	
	}
	public long obtenerRevtotal(){
		return eje.leerRevolucionesTotales();	
	}
	protected void calcularVelocidad(){
		eje.calcularVelocidad(almacena);
	}
	public int leerVelSeleccionada() {
		return almacena.leerVelSeleccionada();
	}
}