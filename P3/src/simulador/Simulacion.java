package simulador;

public class Simulacion extends ListaObservadoresObservables implements Runnable {
	
	private final int INTERVALO = 100; 
	private boolean running = true;
	private int t;
	
	private PanelEtiquetas pe;
	private PanelBotones pb;
	
	public Simulacion(PanelEtiquetas panelE, PanelBotones panelB){
		pe = panelE;
		pb = panelB;
		this.incluir(panelE);
		this.incluir(panelB);
		t = 0;
	}
	
	public void terminate(){
		running = false;
	}
	
	public void run() {
		
		while(running){
			try{ 
				Thread.sleep(INTERVALO);
				t += INTERVALO;
			}
			catch(java.lang.InterruptedException e){
				e.printStackTrace();
				running = false;
			}
			
			this.notificarObservadores();
		}
	}
	
	public int getTiempoTranscurrido(){
		return t;
	}
	
	public PanelEtiquetas getPanelEtiquetas(){
		return pe;
	}
	
	public PanelBotones getPanelBotones(){
		return pb;
	}
}