#ifndef __SPICY_PIZZA_BUILDER__
#define __SPICY_PIZZA_BUILDER__

#include <PizzaBuilder.h>

class SpicyPizzaBuilder : public PizzaBuilder
{
	public:
		void buildDough();	
		void buildSauce();	
		void buildTopping();

		~SpicyPizzaBuilder();
};

#endif