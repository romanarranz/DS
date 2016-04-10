#ifndef STACKIMPL_H
#define STACKIMPL_H

class StackImpl
{
	public:
		virtual void push(int i) = 0;
		virtual int pop() = 0;
		virtual int top() = 0;
		virtual bool isEmpty() = 0;
		virtual bool isFull() = 0;

		virtual ~StackImpl(){}
};

#endif