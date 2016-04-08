#include <Color.h>
#include <Point.h>
#include <Circle.h>

#include <iostream>

using namespace std;

int main()
{
	Color * azul = new Color(0,0,255);
	Point * puntoOrigen = new Point(2.39, 0.12);
	
	double radio = 10.5;
	Circle * c = new Circle( radio , azul, puntoOrigen);
	
	cout << "Diametro: " << c->getDiameter() << endl;
	cout << "Radio circunferencia: " << c->getCircumference() << endl;
	cout << "Color: " << c->getColor() << endl;

	delete c;
}