#include "blackjack.h"

#include <iostream>

using std::cin;
using std::cout;

Blackjack::Blackjack(){

}

int Blackjack::getPoints(Card c){
    switch(c.valor){
        case 11: case 12: case 13:
            return 10;
            break;
        default:
            return c.valor;
            break;
    }
}

int Blackjack::getScore(list<Card> l){
    list<Card>::iterator it;
    int sum = 0;

    for(it = l.begin(); it != l.end(); it++)
        sum += getPoints(*it);

    return sum;
}

char Blackjack::getCommand(){
    char c;

    do {
        cout << "Enter d for draw or s for stand: ";
        cin >> c;
    } while(c != 'd' && c != 's');

    return c;
}

list <Card> Blackjack::humanPlayer(Deck& d){
    list <Card> humanCards;
    int humanScore = 0;
    int cards = 0;
    string cartas = "[";

    while(getCommand() != 's'){
        humanCards.push_back(d.cl.front());

        if(cards > 0)
            cartas += ", ";

        cartas += d.cl.front().toString();
        cards++;

        cout << cartas << "] -- Score: ";

        d.cl.pop_front();
        humanScore = getScore(humanCards);
        cout << humanScore << endl;

        if(humanScore > 21){
            cout << "You lost, your score is above 21\n";
            break;
        }
    }

    return humanCards;
}

list <Card> Blackjack::computerPlayer(Deck d, int humanScore){
    list <Card> computerCards;
    string cartas = "[";
    int computerScore = 0, cards = 0;

    do{
        if(humanScore > 21 || (humanScore == 21 && computerScore == 21))
            break;

        computerCards.push_back(d.cl.front());

        if(cards > 0)
            cartas += ", ";

        cartas += d.cl.front().toString();
        cards++;

        cout << cartas << "] -- Score : ";

        d.cl.pop_front();
        computerScore = getScore(computerCards);
        cout << computerScore << endl;
    } while((computerScore <= humanScore));

    return computerCards;
}

void Blackjack::game(){
    Deck d;

    d.riffleShuffle(10);

    list < Card > humanCards = humanPlayer(d);
    int humanScore = getScore(humanCards);

    int winner = -1;

    if(humanScore <= 21){
        list < Card > computerCards = computerPlayer(d, humanScore);
        int computerScore = getScore(computerCards);

        humanScore > computerScore || computerScore > 21? winner = 1 : humanScore < computerScore ? winner = 2 : winner = 0;

        switch(winner){
            case 0:
                cout << "It is a draw, both you and the computer scored " << humanScore << endl;
                break;
            case 1:
                cout << "You won, your score is " << humanScore << " while the computer scored " << computerScore << endl;
                break;
            case 2:
                cout << "You lost, your score is " << humanScore << " while the computer scored " << computerScore << endl;
                break;
        }
    }
}
