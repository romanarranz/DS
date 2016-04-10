#ifndef STACK_H
#define STACK_H

#include <StackImpl.h>
#include <StackArray.h>
#include <StackList.h>

#include <iostream>
#include <string.h>

using namespace std;

class Stack
{
	private:
		StackImpl * impl;

	public:
		Stack();
		Stack(string s);
		void push(int in);
		int pop();
		int top();
		bool isEmpty();
		bool isFull();

		~Stack();
};

#endif