#ifndef _CIRCULO_
#define _CIRCULO_

#include <figura.h>

class Circulo: public Figura
{
	protected:
		double radio;

	public:
		Circulo();
		Circulo( const double & radio );
		double getArea();
};

#endif