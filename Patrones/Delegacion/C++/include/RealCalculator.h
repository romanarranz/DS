#ifndef REALCALCULATOR_H
#define REALCALCULATOR_H

#include <CalculatorInterface.h>

class RealCalculator : public CalculatorInterface
{
	public:
		int add(int a, int b);
		int mul(int a, int b);
		float div(int a, int b);	
		int sub(int a, int b);
};

#endif