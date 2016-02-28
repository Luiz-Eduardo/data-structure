#ifndef BLACKJACK_H
#define BLACKJACK_H

#include "deck.h"

class Blackjack{
public:
    Blackjack();
    int getPoints(Card c);
    int getScore(list<Card> l);
    char getCommand();
    list <Card> humanPlayer(Deck &d);
    list <Card> computerPlayer(Deck d, int humanScore);
    void game();
};

#endif // BLACKJACK_H
