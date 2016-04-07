#ifndef __POINT__
#define __POINT__

#include <string.h>
#include <cmath>

using namespace std;

// 2. Design a "wrapper" class
class Point {
	private:
		PointCarte * pc;
	  
	public:
		Point( const double & xx, const double & yy );	
		string toString();
	
		// 4. Wrapper maps
		void move( const int & dx, const int & dy );	
		void rotate( const int & angle, const Point & o );
		~Point();
};

#endif