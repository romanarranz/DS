#include <Point.h>

Point::Point(const double & xx, const double & yy){
	pc = new PointCarte(xx,yy);
}

string Point::toString(){
	return pc->toString();
}

void Point::move(const int & dx, const int & dy){
	pc->move(dx,dy);
}

void Point::rotate(const int & angle, Point * o){
	double x = pc->getX() - o->pc->getX();
   	double y = pc->getY() - o->pc->getY();
    
    PointPolar * pp = new PointPolar( sqrt(x*x + y*y), atan2(y,x)*180/M_PI );

    // 4. Wrapper maps
    pp->rotate( angle );
    cout << "  PointPolar is " << pp->toString() << " ";

    string str = pp->toString();
    int i = str.find( '@' );
    double r = stod( str.substr(1,i) );
    double a = stod( str.substr(i+1,str.length()-1) );
    pc = new PointCarte(r*cos(a*M_PI/180) + o->pc->getX(), r*sin(a*M_PI/180) + o->pc->getY());
}