#include <Stack.h>
#include <StackFIFO.h>
#include <StackHanoi.h>

#include <iostream>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */

using namespace std;

template <typename T,unsigned S>
inline unsigned arraysize(const T (&v)[S]) { return S; }

int main()
{
	Stack * stacks[] = {
		new Stack("array"),
		new Stack("list"),
		new StackFIFO(),
		new StackHanoi()
	};

    
	for (int i = 1; i<15; i++)
    	for (int j = 0; j<3; j++)
        	stacks[j]->push(i);

    // initialize random seed:
  	srand (time(NULL));
    int rn;
    for (int i = 1; i < 15; i++){
        rn = rand() % 20 + 1;
        (reinterpret_cast<StackHanoi*> (stacks[3]))->push(rn);        
    }
    
    for (int i = 0; i < arraysize(stacks); i++) {
        while ( !stacks[i]->isEmpty()) {
            cout << stacks[i]->pop() << "  ";
        }
        cout << "\n";
    }
    cout << "total rejected is " << (reinterpret_cast<StackHanoi*> (stacks[3]))->reportRejected() << "\n";
    
}