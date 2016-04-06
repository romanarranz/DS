/*Ejemplo de sujeto observable. Es una clase que mantiene un valor entero en
*el rango 0..maximo, donde maximo se establece en la construccion. La clase
*dispone de metodos para modificar el valor y para acceder al estado
*(valor, maximo). Extiende la clase observable heredando su
*/

package wikipedia;

public class Contador extends Observable {

	//Atributos privados que mantienen el estado del contador
    private int valor, maximo;
    
    /*El constructor inicializa el estado del objeto: el maximo y el
    *valor inicial, siempre en el rango 0..maximo. Adicionalmente,
    *inicializa la parte de Observable que tiene un Contador...
    */
    public Contador(int valor, int maximo) {
        super();
        this.maximo = maximo;
        this.valor = enRango(valor);
    }
    
    //Este metodo privado asegura que un valor n esta entre 0..maximo
    private int enRango(int n) {
        if (n < 0) {
            return 0;
        } else if (n > maximo) {
            return maximo;
        } else {
            return n;
        }
    }
    
    //Estos dos metodos permiten el acceso al estado del contador
    public int valor() {
        return valor;
    }
    
    public int maximo() {
        return maximo;
    }
    
    /*Este metodo afecta al estado: primero se modifica de forma consistente
    *el estado y despues se notifica a los observadores del cambio
    */
    public void incrementarContador(int n) {
        valor = enRango(valor+n);
        notificarObservadores();
    }
}
