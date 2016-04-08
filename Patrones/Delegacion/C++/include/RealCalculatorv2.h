#ifndef REALCALCULATOR_V2_H
#define REALCALCULATOR_V2_H

#include <CalculatorInterface.h>

class RealCalculatorv2 : public CalculatorInterface
{
	public:
		int add(int a, int b);
		int mul(int a, int b);
		float div(int a, int b);
		int sub(int a, int b);		
};

#endif