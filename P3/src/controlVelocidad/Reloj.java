package controlVelocidad;
public class Reloj extends Thread {
	private final int INTERVALO = 250;
	private ControlVelocidad control;
	private int t;
	private volatile boolean running = true;

    public void terminate() {
        running = false;
    }

	public Reloj(ControlVelocidad ControlVelocidad_c) {
		this.control = ControlVelocidad_c;
		this.t = 0;
	}
	
	public void run() {
		while(running){
			try{ 
				sleep(INTERVALO);
				t += INTERVALO;
			}
			catch(java.lang.InterruptedException e) {
				e.printStackTrace();
				running = false;
			}	
			control.controlarEstado();
		}
	}
	
	public int getTiempoTranscurrido(){
		return t;
	}
}