package ejer1;

public enum TC {
	CARRETERA(0), MONTANA(1);
	
	protected int tipo;
	TC(int tipo){
		this.tipo = tipo;
	}
	
	public String toString(){
		String msg;
		if(tipo == 0)
			msg = "CARRETERA";
		else
			msg = "MONTANA";
		return msg;
	}
}
