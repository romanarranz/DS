#include "../include/AbstraccionRefinada.h"
#include "../include/ImplementacionA.h"
#include "../include/ImplementacionB.h"

using namespace std;

int main() {
    Abstraccion * abstracciones[] = {
        new AbstraccionRefinada(new ImplementacionA()),
        new AbstraccionRefinada(new ImplementacionB())
    };

    abstracciones[0]->operacion();
    abstracciones[1]->operacion();

    return 0;
}