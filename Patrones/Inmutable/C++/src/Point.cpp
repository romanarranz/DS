#include <Point.h>

Point::Point(const double & xx, const double & yy){
	this->x = xx;
	this->y = yy;
}

double Point::getX(){
	return this->x;
}

double Point::getY(){
	return this->y;
}