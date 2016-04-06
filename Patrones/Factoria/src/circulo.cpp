#include <circulo.h>

Circulo::Circulo()
{
	this->radio = 0;
	this->ancho = 0;
	this->alto = 0;
}

Circulo::Circulo(const double & radio)
{
	this->radio = radio;
	this->ancho = (2*radio);
	this->alto = (2*radio);
}

double Circulo::getArea()
{
	return (3.14*2*this->radio);
}