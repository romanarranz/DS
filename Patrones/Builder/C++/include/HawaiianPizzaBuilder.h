#ifndef __HAWAIIAN_PIZZA_BUILDER__
#define __HAWAIIAN_PIZZA_BUILDER__

#include <PizzaBuilder.h>

class HawaiianPizzaBuilder : public PizzaBuilder
{
	public:
		void buildDough();	
		void buildSauce();	
		void buildTopping();

		~HawaiianPizzaBuilder();
};

#endif