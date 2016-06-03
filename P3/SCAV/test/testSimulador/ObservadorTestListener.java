package testSimulador;

import simulador.Interfaz;
import simulador.Observador;

/*
Para probarlo se tiene que unir todos lso observadores de la palicacion, panel de etiquetas y panel de botones 
en una misma clase observadora.

Ahora una instancia de esa clase observadora hay que utilizarla dentro de un listener que nos permita asociarle
observadores, de tal manera que cada vez que se acciona algo en ese listener se llama a notificar a esos observadores.

Ejemplo arranco, reinicio, freno pongo el coche a 0 y paro el motor.
Lo que haremos será comprobar que todos los observadores han sido notificados de todos esos eventos a través
del falso listener. Es decir comprobaremos dos listas. una por cada obsverador.

Comprobamos la lista de eventos que hemos disparado (string) con las listas de esos observadores (lista de strging tb)
*/

public class ObservadorTestListener implements Observador {
	
	private Interfaz i;
	
	public ObservadorTestListener(Interfaz in){
		i = in;
	}

	@Override
	public void actualizar() {
		i.getSimulacion().getEventosProducidos().get(this).add(new String("actualizarObservadorTest"));
	}
}
