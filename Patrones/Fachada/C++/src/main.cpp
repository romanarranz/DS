#include <Line.h>

#include <iostream>

using namespace std;

int main()
{
    // 3. Client uses the Facade
    Line * line1 = new Line( new Point(2,4), new Point(5,7) );
    
    line1.move(-2,-4);
    cout << "after move: " << line1 << endl;
    
    line1.rotate(45);       
    cout << "after rotate: " << line1 << endl;
    
    Line * line2 = new Line( new Point(2,1), new Point(2.866,1.5) );
    line2.rotate(30);
    cout << "30 degrees to 60 degrees: " << line2 << endl;

    delete line1;
    delete line2;
}