#include <Waiter.h>

void Waiter::setPizzaBuilder(PizzaBuilder * pb){
	pizzaBuilder = pb;
}

Pizza * Waiter::getPizza(){
	return pizzaBuilder->getPizza();
}

void Waiter::constructPizza(){
	pizzaBuilder->createNewPizzaProduct();
	pizzaBuilder->buildDough();
	pizzaBuilder->buildSauce();
	pizzaBuilder->buildTopping();
}