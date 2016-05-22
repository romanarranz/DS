package simulador;
public class Simulacion extends Observable implements Runnable {
	
	private final int INTERVALO = 100;

	public Simulacion(PanelEtiquetas panelE, PanelBotones panelB){
		this.agregarObservador(panelE);
		this.agregarObservador(panelB);
	}
	public void run() {
		while(true){
			try{ 
				Thread.sleep(INTERVALO);
			}
			catch(java.lang.InterruptedException e){
				e.printStackTrace();
			}
			
			this.notificarObservadores();
		}
	}
}