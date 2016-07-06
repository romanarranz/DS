#ifndef LEGACYRECTANGLE_H
#define LEGACYRECTANGLE_H

#include <iostream>
using std::cout;
using std::endl;

typedef int Coordinate;

class LegacyRectangle{
  private:
      Coordinate _x1, _y1, _x2, _y2;

  public:
      LegacyRectangle(Coordinate x1, Coordinate y1, Coordinate x2, Coordinate y2);
      void oldDraw();
};

#endif
