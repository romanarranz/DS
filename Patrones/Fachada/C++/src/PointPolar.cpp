#include <PointPolar.h>

PointPolar::PointPolar( const double & r, const double & a ){
	radius = r;
	angle = a;
}

void PointPolar::rotate( const int & ang ) {
	angle += ang % 360;
}

string PointPolar::toString() {
	return "[" + radius + "@" + angle + "]";
}

PointPolar::~PointPolar(){}