#ifndef LINE_H
#define LINE_H

#include <Point.h>

#include <iostream>
#include <string.h>

using namespace std;

class Line
{
	private:
  		Point *o, *e;

	public:
  		Line(Point * ori, Point * end );
  		void move( const int & dx, const int & dy );
  		void rotate( const int & ang );
  		string toString();
};

#endif