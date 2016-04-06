// Observador muy simple que ni siquiera consulta el estado del sujeto...

package wikipedia;

public class Detector implements Observador {
    
    public void actualizar() {
        System.out.println("Detector recibe actualizar!");
    }
}