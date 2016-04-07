#ifndef __POINT_POLAR__
#define __POINT_POLAR__

#include <string.h>

using namespace std;

//1. Subsystem
class PointPolar {
	private:
		double radius, angle;

	public:
		PointPolar( const double & r, const double & a );
		void rotate( const int  & ang );
		string toString();

		~PointPolar();
};

#endif