#include <StackFIFO.h>

// way to construct a super object
StackFIFO::StackFIFO() : Stack("array"){
	temp = new StackList();
}

StackFIFO::StackFIFO(string s) : Stack(s){}

int StackFIFO::pop(){
   
    while ( !isEmpty()) {
        temp->push( pop() );
    }

    int ret =  temp->pop();
    while ( !temp->isEmpty()) {
        push( temp->pop() );
    }
    
    return ret;
}

StackFIFO::~StackFIFO(){
	delete temp;
	temp = 0;
}