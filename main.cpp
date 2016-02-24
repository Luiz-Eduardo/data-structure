#include <iostream>
#include "deck.h"
using namespace std;

void test1();
void test2();
void test3();
void test4();

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

    return 0;
}


void test1(){
    Deck d;
    cout << d.toString() << endl;
}

void test2(){
    Deck d;
    cout << "Drawn cards: " << endl;
    for(int i = 0; i < 52; i++)
        cout << d.draw().toString() << " ";
    cout << endl;
}

void test4(){
    int c[3] = {0, 26, 52};

    for(int i = 0; i < 2; i++){
        cout << "Cut = " << c[i];
        Deck d;
        list <Card> l = d.split(d.cl, c[i]);
        cout << "First heap: " << l.toString();
        cout << "Second heap: " << d.cl.toString();
    }
}
