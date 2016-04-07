#ifndef __POINT_CARTE__
#define __POINT_CARTE__

#include <string.h>

using namespace std;

//1. Subsystem
class PointeCarte
{
	private:
		double x, y;

	public:
		PointeCarte(const double & xx, const double & yy);
		void move(const int & dx, const int & dy);
		string toString();
		double getX();
		double getY();

		~PointeCarte();
};

#endif