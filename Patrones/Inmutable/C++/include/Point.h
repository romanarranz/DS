#ifndef POINT_H
#define POINT_H

class Point
{
	private:
		double x, y;

	public:
		Point(const double & xx, const double & yy);
		double getX();
		double getY();
};

#endif