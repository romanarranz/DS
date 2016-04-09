#include <Octal.h>

Octal::Octal(){}

void Octal::setValue(int in) {
  	char buf[10];
  	sprintf(buf, "%o", in);
  	sscanf(buf, "%d", &value);
}