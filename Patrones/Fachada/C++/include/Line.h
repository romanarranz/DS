#ifndef __LINE__
#define __LINE__

#include <string.h>

using namespace std;

class Line {
	
	private:
		Point * o, * e;
	
	public:
		Line( const Point & ori, const Point & end );	
		void move( const int & dx, const int & dy );	
		void rotate( const int & angle );	
		string toString();
};

#endif