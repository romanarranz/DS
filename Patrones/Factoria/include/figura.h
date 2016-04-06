#ifndef _FIGURA_
#define _FIGURA_

class Figura
{
	public:
		virtual double getArea() = 0;
		
		void setAncho(const double & ancho)
		{
			this->ancho = ancho;
		}
		
		void setAlto(const double & alto)
		{
			this->alto = alto;
		}

	protected:
		double ancho, alto;
};

#endif