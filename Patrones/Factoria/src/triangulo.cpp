#include <triangulo.h>

Triangulo::Triangulo()
{
	this->ancho = 0;
	this->alto = 0;
}

Triangulo::Triangulo(const double & ancho, const double & alto)
{
	this->ancho = ancho;
	this->alto = alto;
}

double Triangulo::getArea()
{
	return (this->ancho * this->alto)/2;
}