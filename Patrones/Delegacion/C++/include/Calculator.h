#ifndef CALCULATOR_H
#define CALCULATOR_H

#include <CalculatorInterface.h>

//changing the implementing object in run-time (normally done in compile time)

//the "delegator"
class Calculator : public CalculatorInterface {
	protected:
		CalculatorInterface * ci;
		
	public:
		// delegation
		Calculator(CalculatorInterface * ci);
	
		// calls the delegate
		int add(int a, int b);	
		int mul(int a, int b);
		float div(int a, int b);
		int sub(int a, int b);
	
		// assign the delegate 
		void setI(CalculatorInterface * i);
};

#endif