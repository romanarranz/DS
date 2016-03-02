package ejer1;

import java.util.ArrayList;

public class FactoriaCarreraCarretera extends FactoriaCarrera{
	
	private int cantidadBicicletas;
	private FactoriaCuadro fc;
	private FactoriaManillar fm;
	private FactoriaRuedas fr;
	
	public FactoriaCarreraCarretera(int n){
		cantidadBicicletas = n;
		
		fc = new FactoriaCuadroCarretera();
		fm = new FactoriaManillarCarretera();
		fr = new FactoriaRuedasCarretera();
	}

	@Override
	public ArrayList<Bicicleta> crearCarrera(TC tipo){
		ArrayList<Bicicleta> participantes = new ArrayList<>();
		
		for(int i = 0; i<cantidadBicicletas; i++){
			Cuadro c = fc.crearCuadro();
			Manillar m = fm.crearManillar();
			Ruedas r = fr.crearRuedas();
			
			BicicletaCarretera b = new BicicletaCarretera(tipo, m, c, r);
			participantes.add(b);
		}

		return participantes;
	}
}
