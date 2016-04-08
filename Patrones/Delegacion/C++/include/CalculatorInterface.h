#ifndef CALCULATOR_INTERFACE_H
#define CALCULATOR_INTERFACE_H

class CalculatorInterface
{
	public:
		virtual int add(int a, int b) = 0;
		virtual int mul(int a, int b) = 0;
		virtual float div(int a, int b) = 0;
		virtual int sub(int a, int b) = 0;
		virtual ~CalculatorInterface(){}
};

#endif