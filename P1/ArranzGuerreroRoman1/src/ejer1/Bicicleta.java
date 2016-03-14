package ejer1;

public abstract class Bicicleta extends Thread{
	protected TC tipo = null;
	protected Manillar m;
	protected Ruedas r;
	protected Cuadro c;
	
	protected int km, numeroCorredor;
	protected boolean running;
	
	Bicicleta(TC tipo, Manillar m, Cuadro c, Ruedas r, int numeroCorredor){
		this.tipo = tipo;
		this.m = m;
		this.c = c;
		this.r = r;
		this.km = 0;
		this.numeroCorredor = numeroCorredor;
		this.running = true;
	}
	
	public abstract String toString();
	public abstract TC getTipo();
	public abstract void setTipo(TC tipo);
	
	public int getKM(){
		return km;
	}
	
	public void parar(){
		running = false;
	}
	
	@Override
	public void run(){
		try {
			while(running){
				Thread.sleep((long) ((Math.random()*1)*1000));
				km++;
			}
		} catch(Exception e) {
    		e.getStackTrace();
    	}
	}
}
