#ifndef POINT_H
#define POINT_H

#include <PointCarte.h>
#include <PointPolar.h>

#include <iostream>
#include <string.h>
#include <math.h>

// 2. Design a "wrapper" class
class Point
{
	private:
		PointCarte * pc;

	public:
		Point(const double & xx, const double & yy);
		string toString();

		void move(const int & dx, const int & dy);
		void rotate(const int & angle, Point * o);
};

#endif