package monitorizacion;
import controlVelocidad.Eje;
public class Notificaciones {
	private long _ateriorRevolAceite;
	private long _ateriorRevolPastillas;
	private long _anteriorRevolRevision;
	protected long _revolAceite;
	protected long _revolPastillas;
	protected long _revolRevision;
	private long _inicialAceite;
	private long _inicialPastillas;
	private long _inicialRevision;
	private long _revActuales;
	public final static String NOTIFACEITE = "Aceite";
	public final static String NOTIFPASTILLAS = "Pastillas";
	public final static String NOTIFREV = "Rev General";
	protected Notificaciones() {
		_inicialAceite = 500000; 
		_inicialPastillas = 1000000; 
		_inicialRevision = 10000000; 
		_revolAceite =  _ateriorRevolAceite = 0;
		_revolPastillas = _ateriorRevolPastillas = 0;
		_revolRevision = _anteriorRevolRevision = 0;
	}
	protected void actualizarNotificaciones(Eje eje){
		_revActuales = eje.leerRevolucionesTotales();
		_revolAceite = _revActuales - _ateriorRevolAceite;
		_revolPastillas = _revActuales - _ateriorRevolPastillas;
		_revolRevision = _revActuales - _anteriorRevolRevision;
	}
	protected long leerRevolAceite() {
		return _revolAceite;
	}
	protected long leerRevolPastillas() {
		return _revolPastillas;
	}
	protected long leerRevolRevision() {
		return _revolRevision;
	}
	protected void iniciarAceite() {
		_ateriorRevolAceite = _revActuales;
	}
	protected void iniciarPastillas() {
		_ateriorRevolPastillas = _revActuales;
	}
	protected void iniciarRevision() {
		_anteriorRevolRevision = _revActuales;
	}
	protected boolean notificarAceite() {
		boolean notifica;
		if(_revolAceite >= _inicialAceite){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected boolean notificarPastillas() {
		boolean notifica;
		if(_revolPastillas >= _inicialPastillas){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected boolean notificarRevision() {
		boolean notifica;
		if(_revolRevision >= _inicialRevision){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected String leerNotifAceite() {
		return NOTIFACEITE;
	}
	protected String leerNotifPastillas() {
		return NOTIFPASTILLAS;
	}
	protected String leerNotifRevision() {
		return NOTIFREV;
	}
}