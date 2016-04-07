#ifndef POINT_POLAR_H
#define POINT_POLAR_H

#include <iostream>
#include <string.h>

using namespace std;

//1. Subsystem
class PointPolar
{
	private:
		double radius, angle;

	public:
		PointPolar(const double & xx, const double & yy);
		void rotate(const int & ang);
		string toString();		
};

#endif