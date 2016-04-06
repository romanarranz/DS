#ifndef __PIZZA__
#define __PIZZA__

#include <iostream>
#include <string.h>

using namespace std;

class Pizza
{
	private:
		string dough = "";
		string sauce = "";
		string topping = "";

	public:
		string getSauce();
		string getDough();
		string getTopping();

		void setDough(string dough);
		void setSauce(string sauce);	
		void setTopping(string topping);

		~Pizza();
};

#endif