#include <Number.h>

string Number::type = "decimal";
Number * Number::INSTANCE = 0;

Number::Number() {
	cout << "constructor: ";	
}

void Number::setType(string t) {
  	type = t;
  	delete INSTANCE;
  	INSTANCE = 0;
}

void Number::setValue(int in) {
    value = in;
}

int Number::getValue() {
    return value;
}

Number::~Number(){}