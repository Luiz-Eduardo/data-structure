#ifndef FILA1_H
#define FILA1_H

#include <stack>
#include <cstdio> //Para utilizar o tipo size_t.

template <class T>
class Fila1{
protected:
    std::stack <T> pilha, fila;
    int tam;
public:
    Fila1();
    void push(T value); //Inserir um elemento no final da fila.
    void pop(); //Remove um elemento do início da fila.
    T poll(); //Remove e retorna o elemento que foi removido do início da fila.
    T front(); //Retorna o elemento que está na frente da fila.
    bool empty(); //Retorna true se estiver vazia ou falso caso contrário.
    int size(); //Retorna a quantidade de elementos na fila.
};

/* Construtor da classe Fila1<> */
template <class T>
Fila1<T>::Fila1(){
    tam = 0;
}

/* Método .push() da classe Fila1<> capaz de inserir um elemento no final da fila. */
template <class T>
void Fila1<T>::push(T value){
    pilha.push(value);
    tam++;
}

/* Método .pop() da classe Fila1<> capaz de remover um elemento do início da fila. */
template <class T>
void Fila1<T>::pop(){
    if(tam == 0) return;


    if(fila.empty()){
        while(!pilha.empty()){
            fila.push(pilha.top());
            pilha.pop();
        }
    }

    fila.pop();
    tam--;
}

template <class T>
T Fila1<T>::poll(){
    if(tam == 0){
        size_t marked = -1;
        return marked;
    }

    if(fila.empty()){
        while(!pilha.empty()){
            fila.push(pilha.top());
            pilha.pop();
        }
    }

    tam--;

    T ans = fila.top();
    fila.pop();

    return ans;
}

/* Método .front() da classe Fila1<> capaz de retornar o elemento do início da fila. */
template <class T>
T Fila1<T>::front(){
    return fila.top();
}

/* Método .empty() da classe Fila1<> capaz de retornar verdadeiro caso a fila esteja vazia
   e retornar falso (0) caso a fila não esteja vazia. */
template <class T>
bool Fila1<T>::empty(){
    if(fila.empty()){
        while(!pilha.empty()){
            fila.push(pilha.top());
            pilha.pop();
        }
    }

    return fila.empty();
}

/* Método .size() da classe Fila1<> capaz de retornar a quantidade de elementos da fila. */
template<class T>
int Fila1<T>::size(){
    return tam;
}

#endif // FILA1_H
