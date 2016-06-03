package monitorizacion;
import controlVelocidad.Eje;
public class Monitorizacion {
	private Deposito deposi;
	private Notificaciones notify;
	private Reseteo reset;
	private CalculadorVelMed velMed;
	private RelojM reloj;
    private Eje eje;
	public Monitorizacion(Eje eje) {
		this.eje = eje;
		reloj = new RelojM(this);
		deposi = new Deposito();
		velMed = new CalculadorVelMed();
		notify = new Notificaciones();
		reset = new Reseteo();
	}
	public void start(){
		reloj.start();
	}
	public String comprobarNotificacionesAceite() {
		String notificacion = null;
		if(notify.notificarAceite()){
			notificacion = notify.leerNotifAceite();
		}
		return notificacion;
	}
	
	public String comprobarNotificacionesPastillas() {
		String notificacion = null;
		if(notify.notificarPastillas()){
			notificacion = notify.leerNotifPastillas();
		}
		return notificacion;
	}	
	public String comprobarNotificacionesGeneral() {
		String notificacion = null;
		if(notify.notificarRevision()){
			notificacion = notify.leerNotifRevision();
		}
		return notificacion;
	}
	public double comprobarCombustible() {
		return deposi.leerNivelActual();
	}	
	public double comprobarCombustibleMedio(){
		return velMed.leerGastoMedio();
	}
	public double comprobarvelMed() {
		return velMed.leerVelMedia();
	}
	synchronized public void notificaciones(){
		deposi.actualizarDeposito(eje);
		velMed.calcularVelocidadMedia(eje);
		notify.actualizarNotificaciones(eje);
		velMed.calcularGastoMedio(eje, deposi);
	}
	public void reseteo(){
		reset.inicializarValores(velMed, eje);
	}
	public void cambiarANivelInicial() {
		deposi.cambiarANivelInicial();		
	}
	public void mecanicoAceite(){
		notify.iniciarAceite();
	}
	public void mecanicoPastillas(){
		notify.iniciarPastillas();
	}
	public void mecanicoGeneral(){
		notify.iniciarRevision();
	}
	public void NotificaMecanico(){
		System.out.printf("\nAceite: %d\n", (int) notify._revolAceite);
		System.out.printf("\nPastillas: %d\n", (int) notify._revolPastillas);
		System.out.printf("\nRevision General %d\n", (int) notify._revolRevision);
	}
	public Reseteo getReseteo(){
		return this.reset;
	}
	public CalculadorVelMed getCalculadorVelMed(){
		return this.velMed;
	}
	public RelojM getReloj(){
		return this.reloj;
	}
	public Notificaciones getNotificaciones(){
		return this.notify;
	}
	public Deposito getDeposito(){
		return this.deposi;
	}
}