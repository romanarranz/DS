#ifndef _FACTORIA_RECTANGULO_
#define _FACTORIA_RECTANGULO_

#include <factoriaFigura.h>
#include <rectangulo.h>

class FactoriaRectangulo: public FactoriaFigura
{
	private:
		Rectangulo * r;

	public:
		FactoriaRectangulo(const double & ancho, const double & alto);
		~FactoriaRectangulo();
		Figura * getFigura();
};

#endif