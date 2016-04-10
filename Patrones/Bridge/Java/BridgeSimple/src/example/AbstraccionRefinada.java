package example;

/** clase refinada que implementa la abstraccion **/
class AbstraccionRefinada implements Abstraccion{
    
	private Implementador implementador;
    
    public AbstraccionRefinada(Implementador implementador){
        this.implementador = implementador;
    }
    
    public void operacion(){
        implementador.operacion();
    }
}