//
// Created by ROMÁN ARRANZ GUERRERO on 10/4/16.
//

#ifndef BRIDGESIMPLE_ABSTRACCIONREFINADA_H
#define BRIDGESIMPLE_ABSTRACCIONREFINADA_H

#include "Implementador.h"
#include "Abstraccion.h"

class AbstraccionRefinada : public Abstraccion
{
    private:
        Implementador * implementador;

    public:
        AbstraccionRefinada(Implementador * imp){
            implementador = imp;
        }

        void operacion(){
            implementador->operacion();
        }
};

#endif //BRIDGESIMPLE_ABSTRACCIONREFINADA_H
