#include <CircleData.h>

CircleData::CircleData(const double & radius, Color * color, Point * origin) {
	this->radius = radius;
	this->color = color;
	this->origin = origin;	
}

double CircleData::getRadius(){
	return this->radius;
}

Color * CircleData::getColor(){
	return this->color;
}

Point * CircleData::getOrigin(){
	return this->origin;
}

CircleData::~CircleData(){
	delete origin;
	delete color;
}