#ifndef _TRIANGULO_
#define _TRIANGULO_

#include <figura.h>

class Triangulo: public Figura
{
	public:
		Triangulo();
		Triangulo( const double & ancho, const double & alto);
		double getArea();
};

#endif