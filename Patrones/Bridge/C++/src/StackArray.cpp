#include <StackArray.h>

StackArray::StackArray(){
	items = new int[12];
	total = -1;
}

void StackArray::push(int in){
	if( !isFull()) {
        items[++total] = in;
    }
}

int StackArray::pop(){
	if (isEmpty()) 
    	return -1;
        
    return items[total--];
}

int StackArray::top(){
	if (isEmpty())
    	return -1;
    
    return items[total];
}

bool StackArray::isEmpty(){
	return total == -1;
}

bool StackArray::isFull(){
	return total == 11;
}

StackArray::~StackArray(){
	delete items;
	items = 0;	
}