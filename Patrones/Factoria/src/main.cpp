#include <iostream>
#include <stdlib.h>     /* atoi */

#include <figura.h>
#include <factoriaFigura.h>
#include <FactoriaCirculo.h>
#include <FactoriaRectangulo.h>
#include <FactoriaTriangulo.h>

using namespace std;

int main(int argc, char ** argv)
{
	const int 	RECTANGULO = 1,
				TRIANGULO = 2,
				CIRCULO = 3;
	int tipo;
	double 	alto, ancho, radio;
	bool salir = false;
	Figura * miFigura = NULL;

	if(argc > 2)
		tipo = atoi(argv[1]);

	if(argc == 3 && tipo == CIRCULO) {
		radio = atof(argv[2]);
		miFigura = (new FactoriaCirculo(radio))->getFigura();
		cout << "CIRCULO: radio = " << radio << endl;
	}
	else if(argc == 4 && tipo == RECTANGULO) {
		ancho = atof(argv[2]);
		alto = atof(argv[3]);
		miFigura = (new FactoriaRectangulo(ancho, alto))->getFigura();
		cout << "RECTANGULO: ancho = " << ancho << ", alto = " << alto << endl;
	}
	else if(argc == 4 && tipo == TRIANGULO) {
		ancho = atof(argv[2]);
		alto = atof(argv[3]);
		miFigura = (new FactoriaTriangulo(ancho, alto))->getFigura();
		cout << "TRIANGULO: ancho = " << ancho << ", alto = " << alto << endl;
	}
	else {
		cout << "Error: La sintaxis es " << argv[0] << " <tipo> [<ancho> & <alto>] | <radio>" << endl;
		salir = true;
	}
	
	if(!salir)
		cout << "El area de la figura es: " << miFigura->getArea() << endl;

	delete miFigura;

	return 0;
}