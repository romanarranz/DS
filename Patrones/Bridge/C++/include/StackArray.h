#ifndef STACK_ARRAY_H
#define STACK_ARRAY_H

#include <StackImpl.h>

class StackArray : public StackImpl
{
	private:
		int * items;
		int total;

	public:
		StackArray();
		void push(int in);
		int pop();
		int top();
		bool isEmpty();
		bool isFull();

		~StackArray();
};

#endif