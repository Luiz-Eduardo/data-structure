#include "deck.h"
#include <iostream>

Deck::Deck(){
    for(int i = 0; i < 4; i++){
        for(int j = 1; j <= 13; j++){
            Card carta(i, j);
            baralho.push_back(carta);
        }
    }
}

string Deck::toString(){
    string cartas = "[";
    list<Card>::iterator it;


    for(it = baralho.begin(); it != baralho.end(); it++){
        if(it != baralho.begin())
            cartas += ", ";
         cartas += (*it).toString();
    }

    cartas += "]";

    return cartas;
}

Card Deck::draw(){
    Card atual(NULL, NULL);

    if(!baralho.size())
        return atual;

    list<Card>::iterator it;
    for(it = baralho.begin(); it != baralho.end(); it++){
            atual = (*it);
            baralho.pop_front();
            return atual;
    }
}

int Deck::cut(int n){

}

list<Card> Deck::split(list<Card> l, int c){

}
