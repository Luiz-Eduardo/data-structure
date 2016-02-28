#include "deck.h"
#include <iostream>
#include <cstdlib>
#include <ctime>

Deck::Deck(){
    for(int i = 0; i < 4; i++){
        for(int j = 1; j <= 13; j++){
            Card carta(i, j);
            cl.push_back(carta);
        }
    }

    srand(time(NULL));
}

string Deck::toString(){
    string cartas = "[";

    list<Card>::iterator it;

    for(it = cl.begin(); it != cl.end(); it++){
        if(it != cl.begin())
            cartas += ", ";
         cartas += (*it).toString();
    }

    cartas += "]";

    return cartas;
}

Card Deck::draw(){
    Card atual(0, 0);

    if(!cl.size())
        return atual;

    atual = cl.front();
    cl.pop_front();

    return atual;
}

int Deck::cut(int n){
    int p = 26, x = 0;

    for(int i = 0; i < n; i++)
        if(rand()%52 < p)
            x++;

    return x;
}

list<Card> Deck::split(list<Card>& l, int c){
    list<Card> aux;

    for (int i = 52-c; i < 52; i++) {
        aux.push_back(l.front());
        l.pop_front();
    }

    return aux;
}

list<Card> Deck::riffle(list<Card> l1, list<Card> l2){
    list<Card> aux;

    Card x(0,1);

    double a, b, c, d;

    for(int i = 0; i < 52; i++){
        a = l1.size(), b = l2.size(), c = a/(a+b), d = b/(a+b);

        if(c > d)
            x = l1.front(), l1.pop_front();
        else
            x = l2.front(), l2.pop_front();

        aux.push_back(x);
    }

    return aux;
}

void Deck::riffleShuffle(int n){
    list<Card> first, second;

    while(n--){
        int a = cut(52);
        first = split(cl, a);
        second = riffle(cl, first);
        cl = second;
    }
}
