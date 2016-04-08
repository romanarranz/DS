#include <Circle.h>

Circle::Circle( const double & radius, Color * color, Point * origin){
	this->circleData = new CircleData(radius, color, origin);
}

double Circle::getCircumference(){
	return this->circleData->getRadius() * M_PI;
}

double Circle::getDiameter() {
	return this->circleData->getRadius() * 2;
}
	
string Circle::getColor(){
	return this->circleData->getColor()->toString();
}

Circle::~Circle(){
	delete circleData;
}