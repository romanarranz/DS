#ifndef STACK_HANOI_H
#define STACK_HANOI_H

#include <Stack.h>

#include <iostream>
#include <string.h>

using namespace std;

class StackHanoi : public Stack
{
	private:
		int totalRejected;

	public:
		StackHanoi();
		StackHanoi(string s);
		int reportRejected();
		void push( int in );

		~StackHanoi();
};

#endif