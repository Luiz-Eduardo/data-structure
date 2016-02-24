#ifndef DECK_H
#define DECK_H

#include <list>
#include "card.h"

using namespace std;

class Deck{
    list<Card> baralho;
public:
    Deck();
    string toString();
    Card draw();
    int cut(int n);
    list<Card> split(list<Card> l, int c);
};

#endif // DECK_H
