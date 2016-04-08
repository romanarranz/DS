#ifndef CIRCLE_H
#define CIRCLE_H

#include <CircleData.h>

#include <iostream>
#include <string.h>
#include <cmath>

using namespace std;

class Circle
{
	private:
		CircleData * circleData;

	public:		
		Circle( const double & radius, Color * color, Point * origin);
		double getCircumference();
		double getDiameter();
		string getColor();

		~Circle();
};

#endif
