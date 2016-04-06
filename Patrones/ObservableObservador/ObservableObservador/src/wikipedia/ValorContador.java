//Un ejemplo de observador concreto de la clase contador.

package wikipedia;

public class ValorContador implements Observador {
    
    //El constructor establece la asociacion entre ValorContador-Contador
    public ValorContador(Contador contador) {
        _contador = contador;
    }
    
    /*Tras ser notificado de un cambio, un observador ValorContador accede
    *al estado del Contador utilizando la asociacion
    */
    public void actualizar() {
        System.out.println("Valor del contador es " + _contador.valor() );
    }
    
    //Mantiene asociacion con el sujeto observable
    private Contador _contador;
}