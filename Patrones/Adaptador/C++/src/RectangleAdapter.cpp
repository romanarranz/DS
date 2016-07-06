#include "RectangleAdapter.h"

RectangleAdapter::RectangleAdapter(Coordinate x, Coordinate y, Dimension w, Dimension h) : LegacyRectangle(x, y, x + w , y + h){
  cout << "RectangleAdapter: create.  (" << x << "," << y << "), width = " << w << ", height = " << h << endl;
}

void RectangleAdapter::draw(){
  cout << "RectangleAdapter: draw." << endl;
  oldDraw();
}
