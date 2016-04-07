#ifndef POINT_CARTE_H
#define POINT_CARTE_H

#include <iostream>
#include <string.h>

using namespace std;

//1. Subsystemw
class PointCarte
{
	private:
		double x,y;

	public:
		PointCarte(const double & xx, const double & yy);
		void move(const int & dx, const int & dy);
		string toString();

		double getX();
		double getY();
};

#endif