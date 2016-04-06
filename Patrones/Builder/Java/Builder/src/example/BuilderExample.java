package example;

/* A customer ordering a pizza */
public class BuilderExample {

	public static void main(String[] args) {
		Waiter waiter = new Waiter();
	    PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
	    PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

	    waiter.setPizzaBuilder( hawaiian_pizzabuilder );
	    waiter.constructPizza();

	    Pizza pizza = waiter.getPizza();
	    System.out.println("Hawaiian Pizza");
	    System.out.println("\tSauce: "+pizza.getSauce());
	    System.out.println("\tTopping: "+pizza.getTopping());
	    System.out.println("\tDough: "+pizza.getDough());	 
	    
	    waiter.setPizzaBuilder( spicy_pizzabuilder );
	    waiter.constructPizza();
	    pizza = waiter.getPizza();
	    System.out.println("Spicy Pizza");
	    System.out.println("\tSauce: "+pizza.getSauce());
	    System.out.println("\tTopping: "+pizza.getTopping());
	    System.out.println("\tDough: "+pizza.getDough());	 
	    
	}
}
