#include <PointCarte.h>

PointCarte::PointCarte(const double & xx, const double & yy){
	this->x = xx;
	this->y = yy;
}

void PointCarte::move(const int & dx, const int & dy){
	this->x += dx;
	this->y += dy;
}

string PointCarte::toString(){
	return "(" + to_string(this->x) + "," + to_string(this->y) + ")";
}

double PointCarte::getX(){
	return this->x;
}

double PointCarte::getY(){
	return this->y;
}