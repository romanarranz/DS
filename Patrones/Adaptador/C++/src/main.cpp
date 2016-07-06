#include "Rectangle.h"
#include "RectangleAdapter.h"

int main(){
  Rectangle * r = new RectangleAdapter(120, 200, 60, 40);
  r->draw();
}
