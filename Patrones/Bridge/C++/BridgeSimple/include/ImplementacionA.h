//
// Created by ROMÁN ARRANZ GUERRERO on 10/4/16.
//

#ifndef BRIDGESIMPLE_IMPLEMENTACIONA_H
#define BRIDGESIMPLE_IMPLEMENTACIONA_H

#include "Implementador.h"

#include <iostream>

using namespace std;

class ImplementacionA : public Implementador
{
    public:
        ImplementacionA(){}
        void operacion(){
            cout << "Esta es Implementacion A\n";
        }
};

#endif //BRIDGESIMPLE_IMPLEMENTACIONA_H
