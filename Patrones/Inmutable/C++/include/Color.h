#ifndef COLOR_H
#define COLOR_H

#include <iostream>
#include <string.h>

using namespace std;

class Color
{
	private:
		int R, G, B;
	
	public:
		Color(int r, int g, int b);
		int getR();
		int getG();
		int getB();
		string toString();
};

#endif