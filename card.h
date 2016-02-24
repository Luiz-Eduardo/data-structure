#ifndef CARD_H
#define CARD_H

#include <string>

using namespace std;

class Card{
    char naipe;
    int valor;
public:
    Card(int naipe, int valor);
    string toString();
};

#endif // CARD_H
