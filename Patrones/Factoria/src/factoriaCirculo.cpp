#include <factoriaCirculo.h>

FactoriaCirculo::FactoriaCirculo(const double & radio)
{
	c = new Circulo(radio);
}

FactoriaCirculo::~FactoriaCirculo()
{
	delete c;
}

Figura * FactoriaCirculo::getFigura()
{
	return this->c;
}