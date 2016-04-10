#ifndef STACK_FIFO_H
#define STACK_FIFO_H

#include <Stack.h>
#include <StackList.h>

#include <iostream>
#include <string.h>

using namespace std;

class StackFIFO : public Stack
{
	private:
		StackImpl * temp;

	public:
		StackFIFO();
		StackFIFO(string s);
		int pop();

		~StackFIFO();
};

#endif