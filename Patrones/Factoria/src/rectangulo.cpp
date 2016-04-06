#include <rectangulo.h>

Rectangulo::Rectangulo()
{
	this->ancho = 0;
	this->alto = 0;
}

Rectangulo::Rectangulo(const double & ancho, const double & alto)
{
	this->ancho = ancho;
	this->alto = alto;
}

double Rectangulo::getArea()
{
	return (this->ancho * this->alto);
}