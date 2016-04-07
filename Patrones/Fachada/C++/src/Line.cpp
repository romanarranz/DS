#include <Line.h>

Line::Line(Point * ori, Point * end ){
	this->o = ori;
	this->e = end;
}

void Line::move( const int & dx, const int & dy ){
	this->o->move(dx, dy);
	this->e->move(dx, dy);
}

void Line::rotate( const int & ang ){
	this->e->rotate(ang, o);
}

string Line::toString(){
	return "origin is " + this->o->toString() + ", end is " + this->e->toString();
}