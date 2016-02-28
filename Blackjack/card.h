#ifndef CARD_H
#define CARD_H

#include <list>
#include <string>

using namespace std;

class Card{
public:
    int valor;
    char naipe;
    Card(int naipe, int valor);
    string toString();
};

#endif // CARD_H
