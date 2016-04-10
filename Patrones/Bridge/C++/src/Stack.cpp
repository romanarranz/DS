#include <Stack.h>

Stack::Stack() : Stack("array"){
	impl = 0;
}

Stack::Stack( string s ) {
    if(s == "array") 
    	impl = new StackArray();
    else if (s == "list")
    	impl = new StackList();
    else
    	cout << "Stack: unknown parameter" << "\n";
 }
 
void Stack::push( int in ){
	impl->push( in );
}
 
int Stack::pop(){
	return impl->pop();
}
 
int Stack::top(){
	return impl->top();
}
 
bool Stack::isEmpty(){
	return impl->isEmpty(); 
}
 
bool Stack::isFull(){
	return impl->isFull();
}

Stack::~Stack(){
	delete impl;
	impl = 0;
}