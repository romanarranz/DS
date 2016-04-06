#include <Pizza.h>

string Pizza::getSauce(){
	return this->sauce;
}

string Pizza::getDough(){
	return this->dough;
}

string Pizza::getTopping(){
	return this->topping;
}

void Pizza::setDough(string dough){
	this->dough = dough; 
}
	
void Pizza::setSauce(string sauce){
	this->sauce = sauce;
}

void Pizza::setTopping(string topping){
	this->topping = topping;
}

Pizza::~Pizza(){}