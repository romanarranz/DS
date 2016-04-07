#include <PointPolar.h>

PointPolar::PointPolar(const double & r, const double & a){
	this->radius = r;
	this->angle = a;
}

void PointPolar::rotate(const int & ang){
	this->angle += ang % 360;
}

string PointPolar::toString(){
	return "[" + to_string(this->radius) + "@" + to_string(this->angle) + "]";
}