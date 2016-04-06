//Un ejemplo de observador concreto de la clase contador.

package wikipedia;

public class Medidor implements Observador {
    
    //El constructor de Medidor establece la asociacion entre Medidor-Contador
    public Medidor(Contador contador) {
        _contador = contador;
    }
    
    /*Tras ser notificado de un cambio, un observador Medidor accede
    *al estado del Contador utilizando la asociacion
    */
    
    public void actualizar() {
        int porcentaje = _contador.valor() * 100 / _contador.maximo();
        System.out.println("Porcentaje del contador es " + porcentaje + "%");
    }
    
    //Mantiene la asociacion con el contador
    private Contador _contador;
}
