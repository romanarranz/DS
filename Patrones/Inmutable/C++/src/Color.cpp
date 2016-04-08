#include <Color.h>

Color::Color(int r, int g, int b){
	this->R = r;
	this->G = g;
	this->B = b;
}

int Color::getR(){
	return this->R;
}

int Color::getG(){
	return this->G;
}

int Color::getB(){
	return this->B;
}

string Color::toString(){
	return to_string(this->R) + "," + to_string(this->G) + "," + to_string(this->B);
}