#include <Number.h>
#include <Octal.h>

#include <iostream>
#include <string.h>

using namespace std;

int main()
{
	// Number myInstance; - error: cannot access protected constructor
	// 5. Clients may only use the accessor function to manipulate the Singleton
	Number::getInstance()->setValue(42);
	cout << "value is " << Number::getInstance()->getValue() << endl;

	Number::setType("octal");
	Number::getInstance()->setValue(64);
	cout << "value is " << Number::getInstance()->getValue() << endl;
}