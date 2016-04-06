package SO;

public class Application {
	public Application(GUIFactory factory){
		Button button = factory.createButton();
		button.paint();
	}
	
	public String sayHello(){
		return "Hola";
	}
}
