#ifndef __WAITER__
#define __WAITER__

#include <PizzaBuilder.h>

class Waiter
{	
	private:
		PizzaBuilder * pizzaBuilder;

	public:
		void setPizzaBuilder(PizzaBuilder * pb);	
		Pizza * getPizza();
		void constructPizza();
};

#endif