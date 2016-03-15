package model;

import GUI.AppWindow;

public class Despachador {
	
	private CambioFiltro filterChain;
	
	public Despachador(AppWindow ui) {
		
		filterChain = new CambioFiltro();
		filterChain.setObjetivo(ui);
	}
	
	public void setFiltro(Filtro f) {
		
		filterChain.anadirFiltro(f);
	}

	public void filtroPeticion(double petition) {
		
		filterChain.ejecutar(petition);
	}

}
