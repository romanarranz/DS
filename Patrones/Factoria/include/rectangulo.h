#ifndef _RECTANGULO_
#define _RECTANGULO_

#include <figura.h>

class Rectangulo: public Figura
{
	public:
		Rectangulo();
		Rectangulo(const double & ancho, const double & alto);
		double getArea();
};

#endif