#include <Calculator.h>

Calculator::Calculator(CalculatorInterface * ci){
	this->setI(ci);
}
	
int Calculator::add(int a, int b){
	return this->ci->add(a,b);
}

int Calculator::mul(int a, int b){
	return this->ci->mul(a,b);	
}

float Calculator::div(int a, int b){
	return this->ci->div(a,b);
}

int Calculator::sub(int a, int b){
	return this->ci->sub(a,b);
}

void Calculator::setI(CalculatorInterface * i){
	this->ci = i;
}