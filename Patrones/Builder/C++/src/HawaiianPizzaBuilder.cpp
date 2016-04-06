#include <HawaiianPizzaBuilder.h>

void HawaiianPizzaBuilder::buildDough(){
	pizza->setDough("cross");
}

void HawaiianPizzaBuilder::buildSauce(){
	pizza->setSauce("mild"); 
}

void HawaiianPizzaBuilder::buildTopping(){
	pizza->setTopping("ham+pineapple");
}

HawaiianPizzaBuilder::~HawaiianPizzaBuilder(){}