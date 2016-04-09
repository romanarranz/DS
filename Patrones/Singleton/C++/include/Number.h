#ifndef NUMBER_H
#define NUMBER_H

#include <iostream>
#include <string>

using namespace std;

class Number
{
	private:
		// 1. Define a private static attribute
		static string type;
		static Number * INSTANCE;

	protected:
		int value;

		// 4. Define all ctors to be protected
		Number();
		virtual ~Number();

	public:
		// 2. Define a public static accessor func
    	static Number * getInstance(); 
    	static void setType(string t);
    	virtual void setValue(int in);
    	virtual int getValue();    	
};

#endif