#include "card.h"
#include <sstream>

Card::Card(int naipe, int valor){
    switch(naipe){
        case 0:
            this->naipe = 'H';
            break;
        case 1:
            this->naipe = 'D';
            break;
        case 2:
            this->naipe = 'S';
            break;
        case 3:
            this->naipe = 'C';
            break;
    }

    this->valor = valor;
}

string Card::toString(){
    string carta = "";

    carta += naipe;

    stringstream buffer;
    buffer << this->valor;
    string numero = buffer.str();

    carta += numero;

    return carta;
}
