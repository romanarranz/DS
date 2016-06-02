package monitorizacion;
public class RelojM extends Thread{
	private final int INTERVALO = 250;
	private  Monitorizacion monitor;
	private int t;
	private volatile boolean running = true;

	public RelojM(Monitorizacion Monitorizacion_m) {
		this.monitor = Monitorizacion_m;
		t = 0;
	}
	
	public void run() {
		while(running){
			try{ 
				sleep(INTERVALO);
				t += INTERVALO;
			}
			catch(java.lang.InterruptedException e){
				e.printStackTrace();
				running = false;
			}
			
			monitor.notificaciones();
		}
	}
    
	public void terminate() {
        running = false;
    }
    
	public int getTiempoTranscurrido(){
		return t;
	}
}