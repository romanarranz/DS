#ifndef OCTAL_H
#define OCTAL_H

#include <Number.h>

#include <stdlib.h>

class Octal: public Number
{
	protected:
		Octal();

	// 6. Inheritance can be supported
	public:
		friend class Number;
		void setValue(int in);	
};

#endif