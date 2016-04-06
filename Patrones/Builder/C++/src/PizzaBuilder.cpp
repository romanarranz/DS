#include <PizzaBuilder.h>

Pizza * PizzaBuilder::getPizza(){
	return pizza;
}
	
void PizzaBuilder::createNewPizzaProduct(){
	pizza = new Pizza();
}

PizzaBuilder::~PizzaBuilder(){}