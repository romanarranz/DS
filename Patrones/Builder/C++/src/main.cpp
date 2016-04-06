#include <Pizza.h>
#include <Waiter.h>
#include <PizzaBuilder.h>
#include <HawaiianPizzaBuilder.h>
#include <SpicyPizzaBuilder.h>

#include <iostream>

using namespace std;

int main()
{
	Waiter * waiter = new Waiter();
	PizzaBuilder * hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
	PizzaBuilder * spicy_pizzabuilder = new SpicyPizzaBuilder();

    waiter->setPizzaBuilder( hawaiian_pizzabuilder );
    waiter->constructPizza();

    Pizza * pizza = waiter->getPizza();
    cout << "Hawaiian Pizza\n";
    cout << "\tSauce: " << pizza->getSauce() << "\n";
    cout << "\tTopping: " << pizza->getTopping() << "\n";
    cout << "\tDough: " << pizza->getDough() << "\n";

    waiter->setPizzaBuilder( spicy_pizzabuilder );
    waiter->constructPizza();

    pizza = waiter->getPizza();
    cout << "Spicy Pizza\n";
    cout << "\tSauce: " << pizza->getSauce() << "\n";
    cout << "\tTopping: " << pizza->getTopping() << "\n";
    cout << "\tDough: " << pizza->getDough() << "\n";

    delete pizza;
    delete hawaiian_pizzabuilder;
    delete spicy_pizzabuilder;
    delete waiter;
}