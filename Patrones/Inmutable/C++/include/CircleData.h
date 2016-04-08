#ifndef CIRCLE_DATA_H
#define CIRCLE_DATA_H

#include <Color.h>
#include <Point.h>

class CircleData
{
	private:
		double radius;
		Color * color;
		Point * origin;
	
	public:
		CircleData(const double & radius, Color * color, Point * origin);	
		double getRadius();	
		Color * getColor();	
		Point * getOrigin();

		~CircleData();
};

#endif