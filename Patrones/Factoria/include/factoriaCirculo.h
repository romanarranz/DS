#ifndef _FACTORIA_CIRCULO_
#define _FACTORIA_CIRCULO_

#include <factoriaFigura.h>
#include <circulo.h>

class FactoriaCirculo: public FactoriaFigura
{
	private:
		Circulo * c;
	public:
		FactoriaCirculo(const double & radio);
		~FactoriaCirculo();
		Figura * getFigura();
};

#endif