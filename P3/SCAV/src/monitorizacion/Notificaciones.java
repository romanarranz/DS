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
	public Notificaciones() {
		_inicialAceite = 500000; 
		_inicialPastillas = 1000000; 
		_inicialRevision = 10000000; 
		_revolAceite =  _ateriorRevolAceite = 0;
		_revolPastillas = _ateriorRevolPastillas = 0;
		_revolRevision = _anteriorRevolRevision = 0;
	}
	public void actualizarNotificaciones(Eje eje){
		_revActuales = eje.leerRevolucionesTotales();
		_revolAceite = _revActuales - _ateriorRevolAceite;
		_revolPastillas = _revActuales - _ateriorRevolPastillas;
		_revolRevision = _revActuales - _anteriorRevolRevision;
	}
	public long leerRevolAceite() {
		return _revolAceite;
	}
	public long leerRevolPastillas() {
		return _revolPastillas;
	}
	public long leerRevolRevision() {
		return _revolRevision;
	}
	public void iniciarAceite() {
		_ateriorRevolAceite = _revActuales;
	}
	public void iniciarPastillas() {
		_ateriorRevolPastillas = _revActuales;
	}
	public void iniciarRevision() {
		_anteriorRevolRevision = _revActuales;
	}
	public boolean notificarAceite() {
		boolean notifica;
		if(_revolAceite >= _inicialAceite){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	public boolean notificarPastillas() {
		boolean notifica;
		if(_revolPastillas >= _inicialPastillas){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	public boolean notificarRevision() {
		boolean notifica;
		if(_revolRevision >= _inicialRevision){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	public String leerNotifAceite() {
		return NOTIFACEITE;
	}
	public String leerNotifPastillas() {
		return NOTIFPASTILLAS;
	}
	public String leerNotifRevision() {
		return NOTIFREV;
	}
	public void setRevolPastillas(long a){
		this._revolPastillas = a;
	}
}