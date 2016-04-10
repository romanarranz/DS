#ifndef STACK_LIST_H
#define STACK_LIST_H

#include <StackImpl.h>
#include <Node.h>

class StackList : public StackImpl
{
	private:
		Node * last;

	public:
		StackList();
		void push(int in);
		int pop();
		int top();
		bool isEmpty();
		bool isFull();

		~StackList();
};

#endif