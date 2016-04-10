#include <StackList.h>

StackList::StackList(){
	last = 0;
}

void StackList::push(int in){
    if (last == 0)
        last = new Node(in);
    else {
        last->next = new Node(in);
        last->next->prev = last;
        last = last->next;
    }
}

int StackList::pop(){
	
	int value;
	if (isEmpty())
		value = -1;
    
    value = last->value;
    last = last->prev;
    
    return value;
}

int StackList::top(){
	int value;
    if (isEmpty())
    	value = -1;
    
    value = last->value;
    
    return value;
}

bool StackList::isEmpty(){
	return last == 0;
}

bool StackList::isFull(){
	return false;
}

StackList::~StackList(){
	delete last;
	last = 0;
}