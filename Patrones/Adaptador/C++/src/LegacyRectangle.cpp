#include "LegacyRectangle.h"

LegacyRectangle::LegacyRectangle(Coordinate x1, Coordinate y1, Coordinate x2, Coordinate y2){
  _x1 = x1;
  _y1 = y1;
  _x2 = x2;
  _y2 = y2;

  cout << "LegacyRectangle:  create.  (" << _x1 << "," << _y1 << ") => (" << _x2 << "," << _y2 << ")" << endl;
}

void LegacyRectangle::oldDraw(){
  cout << "LegacyRectangle:  oldDraw.  (" << _x1 << "," << _y1 << ") => (" << _x2 << "," << _y2 << ")" << endl;
}
