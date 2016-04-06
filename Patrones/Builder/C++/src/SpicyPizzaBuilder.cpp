#include <SpicyPizzaBuilder.h>

void SpicyPizzaBuilder::buildDough(){
	pizza->setDough("pan baked");
}

void SpicyPizzaBuilder::buildSauce(){
	pizza->setSauce("hot"); 
}

void SpicyPizzaBuilder::buildTopping(){
	pizza->setTopping("pepperoni+salami");
}

SpicyPizzaBuilder::~SpicyPizzaBuilder(){}