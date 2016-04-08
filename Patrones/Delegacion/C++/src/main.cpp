#include <CalculatorInterface.h>
#include <Calculator.h>
#include <RealCalculator.h>
#include <RealCalculatorv2.h>

#include <iostream>

using namespace std;

int main()
{
	Calculator * c = new Calculator(new RealCalculator());
	cout << c->add(10, 20) << endl;
	cout << c->mul(2, 3) << endl;
	
	c->setI(new RealCalculatorv2());
	cout << c->add(10, 20) << endl;
	cout << c->mul(2, 3) << endl;	
}