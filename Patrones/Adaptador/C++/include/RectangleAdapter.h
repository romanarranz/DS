#ifndef RECTANGLEADAPTER_H
#define RECTANGLEADAPTER_H

#include <iostream>

#include "Rectangle.h"
#include "LegacyRectangle.h"

using std::cout;
using std::endl;

typedef int Dimension;

class RectangleAdapter: public Rectangle, private LegacyRectangle {
  public:
    RectangleAdapter(Coordinate x, Coordinate y, Dimension w, Dimension h);
    virtual void draw();
};

#endif
