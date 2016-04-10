//
// Created by ROMÁN ARRANZ GUERRERO on 10/4/16.
//

#ifndef BRIDGESIMPLE_IMPLEMENTACIONB_H
#define BRIDGESIMPLE_IMPLEMENTACIONB_H

#include "Implementador.h"

#include <iostream>

using namespace std;

class ImplementacionB : public Implementador
{
    public:
        ImplementacionB(){}
        void operacion(){
            cout << "Esta es la Implementacion B\n";
        }
};

#endif //BRIDGESIMPLE_IMPLEMENTACIONB_H
