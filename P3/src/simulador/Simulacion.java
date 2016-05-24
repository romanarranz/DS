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
	
	public PanelEtiquetas getPanelEtiquetas(){
		return (PanelEtiquetas) this.lObservadores.getObservadores().get(0);
	}
	
	public PanelBotones getPanelBotones(){
		return (PanelBotones) this.lObservadores.getObservadores().get(1);
	}
}