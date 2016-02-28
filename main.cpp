#include <iostream>
#include "deck.h"
#include "blackjack.h"

using namespace std;

void test1();
void test2();
void test4();
void test5();
void test6();
void test7();
void test8();
string toString(list<Card> cl);

int main(){
    /*
    Card c0(0,1);
    Card c1(1, 10);
    Card c2(2, 11);
    Card c3(3, 13);

    cout << " " << c0.toString() << " " << c1.toString() << " " << c2.toString() << " " << c3.toString();
    */
    //test1();
    //test2();
    //test4();
    //test5();
    //test6();
    //test7();
    //test8();
    //Blackjack bj;
    //Deck d;

    //bj.humanPlayer(d);
    //bj.computerPlayer(d, 20);

    Blackjack bj;

    bj.game();

    return 0;
}


void test1(){
    Deck d;
    cout << d.toString() << endl;

    Card c0(0,1), c1(0,7), c2(1, 10), c3(2, 11), c4(3,13);
    Blackjack bj;
    cout << bj.getPoints(c0) << endl;
    cout << bj.getPoints(c1) << endl;
    cout << bj.getPoints(c2) << endl;
    cout << bj.getPoints(c3) << endl;
    cout << bj.getPoints(c4) << endl;
}

void test2(){
    Deck d;
    cout << "Drawn cards: " << endl;
    for(int i = 0; i < 52; i++)
        cout << d.draw().toString() << " ";
    cout << endl;

    list<Card> l;
    Card c0(0, 1);
    l.push_back(c0);
    Card c1(1, 10);
    l.push_back(c1);
    Card c2(2,11);
    l.push_back(c2);
    Card c3(3, 13);
    l.push_back(c3);
    Blackjack bj;
    cout << bj.getScore(l) << endl;

}

void test4(){
    int c[3] = {0, 26, 52};

    for(int i = 0; i < 3; i++){
        cout << "Cut = " << c[i] << endl;

        Deck d;
        list <Card> l = d.split(d.cl, c[i]);

        cout << "First heap: " << toString(l) << endl;
        cout << "Second heap: " << toString(d.cl) << endl;
    }
}

void test5(){
    Deck d;

    list<Card> l = d.split(d.cl, 26);

    cout << "First heap: " << toString(l) << endl;
    cout << "Second heap: " << toString(d.cl) << endl;
    cout << "Riffle result: " << toString(d.riffle(l, d.cl)) << endl;
}

void test6(){
    int x = 7;

    Deck d;
    while(x--)
        cout << d.cut(52);
    /*

    cout << d.toString() << endl;
    d.riffleShuffle(7);
    cout << endl;
    cout << toString(d.cl) << endl; */
}

void test7(){
    Blackjack bj;
    Deck d;

    bj.humanPlayer(d);
}

void test8(){
    Blackjack bj;
    Deck d;

    bj.computerPlayer(d, 20);
    bj.computerPlayer(d, 15);
    bj.computerPlayer(d, 8);
    bj.computerPlayer(d, 3);
}

string toString(list<Card> cl){
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
