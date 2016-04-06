#ifndef _FACTORIA_TRIANGULO_
#define _FACTORIA_TRIANGULO_

#include <factoriaFigura.h>
#include <triangulo.h>

class FactoriaTriangulo: public FactoriaFigura
{
	private:
		Triangulo * t;

	public:
		FactoriaTriangulo(const double & ancho, const double & alto);
		~FactoriaTriangulo();
		Figura * getFigura();
};

#endif