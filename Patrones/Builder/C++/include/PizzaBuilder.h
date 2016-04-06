#ifndef __PIZZA_BUILDER__
#define __PIZZA_BUILDER__

#include <Pizza.h>

class PizzaBuilder
{
	protected:
		Pizza * pizza;

	public:
		Pizza * getPizza();
		void createNewPizzaProduct();
		virtual void buildDough() = 0;
		virtual void buildSauce() = 0;
		virtual void buildTopping() = 0;
		virtual ~PizzaBuilder();
};

#endif