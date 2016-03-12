package ejer3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cliente {
	private int descuento;
	private TipoCliente tipo;

	// Equipo que consulta el cliente
	private Equipo equipo; 
	
	// Definicion de visitantes
	private VisitanteNombre vNombre;
	private VisitantePrecio vPrecio;
	private VisitantePrecioConDescuento vDescuento;
	
	Cliente(TipoCliente t, Equipo e, VisitanteEquipo ve){		
		this.tipo = t;
		
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
		
		vNombre = (VisitanteNombre) ve;
		//vPrecio = (VisitantePrecio) ve;
		//vDescuento = (VisitantePrecioConDescuento) ve;
		
		equipo = e;
	}
	
	public int getDescuento(){
		return descuento;
	}
	
	public int getTipo(){
		return tipo.getTipo();
	}
	
	public static int endThreadCounter = 0;
	private int totalThread = 20;
	public void runTests() {
		  Consulta testCase = new Consulta(equipo, vNombre);
		  ExecutorService executor = Executors.newCachedThreadPool();
		  
		  if(totalThread >= 25)
			  this.descuento = this.descuento+5;
		  
		  for (int i = 0; i < totalThread; i++) 
			  executor.execute(testCase);
		  		  
		  // Finalizamos el lanzador de hebras
		  executor.shutdown();
		  try {
			  // TTL de 60s
			  executor.awaitTermination(60, TimeUnit.SECONDS);
		  }
		  catch(InterruptedException e){
			  e.printStackTrace();
		  }
		  // Imprimimos cuantas hebras han acabado
		  System.out.println("Han acabado "+endThreadCounter+" hebras");
	}
}
