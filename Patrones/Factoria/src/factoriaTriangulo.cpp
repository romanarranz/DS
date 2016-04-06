#include <factoriaTriangulo.h>

FactoriaTriangulo::FactoriaTriangulo(const double & ancho, const double & alto)
{
	t = new Triangulo(ancho, alto);
}

FactoriaTriangulo::~FactoriaTriangulo()
{
	delete t;
}

Figura * FactoriaTriangulo::getFigura()
{
	return this->t;
}