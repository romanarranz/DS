package ejer3;

import java.util.ArrayList;

import GUI.AppWindow;

public class Cliente implements Runnable{
	private int descuento, contadorHebrasPersonal;
	private TipoCliente tipo;
	private AppWindow gui;
	private boolean running;
	
	public static int contadorHebras, totalHebras, totalClientes = 0;
	
	// Equipo que consulta el cliente
	private ArrayList<Equipo> configuracionEquipo; 

	private int idCliente;
	
	Cliente(int idCliente, TipoCliente t, ArrayList<Equipo> config, AppWindow gui){		
		this.idCliente = idCliente;
		this.tipo = t;
		this.configuracionEquipo = config;		
		this.gui = gui;
		this.contadorHebras = 0;
		this.totalHebras = 100;
		this.running = true;
		
		Cliente.totalClientes++;
		
		gui.addRow();
		
		switch(tipo.getTipo()){
			case 1:
				this.descuento = 10;
				break;
			case 2:
				this.descuento = 15;
				break;
			default:
				this.descuento = 0;
		}		
	}
	
	@Override
	public void run(){
		if(totalHebras >= 25)
			  this.descuento = this.descuento+5;
		  
		  while(running){
			  try {
				  Thread.sleep(ApplicationRunner.randInt(1,4)*10);
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
			  
			  double precio;
			  VisitanteEquipo visitante = new VisitanteNombre();
			  gui.setDato(idCliente, 0, tipo.toString());
			  gui.setDato(idCliente, 1, contadorHebrasPersonal);
			
			  for(int i = 0; i<configuracionEquipo.size(); i++)
				  configuracionEquipo.get(i).aceptar(visitante);
			  gui.setDato(idCliente, 2, ((VisitanteNombre) visitante).getNombre());
			
			  visitante = new VisitantePrecio();
			  for(int i = 0; i<configuracionEquipo.size(); i++)
				  configuracionEquipo.get(i).aceptar(visitante);
			
			  precio = ((VisitantePrecio) visitante).getPrecio();
			  gui.setDato(idCliente, 3, precio);
			  gui.setDato(idCliente, 4, descuento);
						  
			  Cliente.contadorHebras++;
			  contadorHebrasPersonal++;
			  
			  if(Cliente.contadorHebras > Cliente.totalHebras-Cliente.totalClientes)
				  running = false;
		}
	}
}
