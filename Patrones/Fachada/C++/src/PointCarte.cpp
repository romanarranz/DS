#include <PointCarte.h>

PointCarte::PointCarte( const double & xx, const double & yy ) {
	x = xx;
	y = yy;
}

void  PointCarte::move( const int & dx, const int & dy ) {
	x += dx;
	y += dy;
}

string PointCarte::toString() {
	return "(" + x + "," + y + ")";
}

double PointCarte::getX() {
	return x;
}

double PointCarte::getY() {
	return y;
}

PointCarte::~PointCarte(){}