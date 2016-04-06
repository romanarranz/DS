#include <factoriaRectangulo.h>

FactoriaRectangulo::FactoriaRectangulo(const double & ancho, const double & alto)
{
	r = new Rectangulo(ancho, alto);
}

FactoriaRectangulo::~FactoriaRectangulo()
{
	delete r;
}

Figura * FactoriaRectangulo::getFigura()
{
	return this->r;
}