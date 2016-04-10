#include <StackHanoi.h>

StackHanoi::StackHanoi() : Stack("array"){
	totalRejected = 0;	
}

StackHanoi::StackHanoi(string s) : Stack(s){
	totalRejected = 0;
}

int StackHanoi::reportRejected(){
	return totalRejected;
}

void StackHanoi::push( int in ){
    if ( !isEmpty()  &&  in > top()) {
        totalRejected++;        
    }
    else {
        Stack::push( in );
    }
}

StackHanoi::~StackHanoi(){}