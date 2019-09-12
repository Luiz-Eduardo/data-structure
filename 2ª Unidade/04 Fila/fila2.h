#ifndef FILA2_H
#define FILA2_H

#include <stack>

template <class T>
class Fila2{
protected:
    std::stack<T> pilha;
    void remove(); //Função recursiva capaz de remover o elemento que está no fim da pilha, isto é, início da fila
    void topo(); //Função recursiva capaz de resgatar o elemento que está no fim da pilha, isto é, início da fila.
    T top;
    int tam;
public:
    Fila2();
    void push(T value); //Inserir um elemento no final da fila.
    void pop(); //Remover um elemento do início da fila.
    T front(); //Retorna o elemento que está na frente da fila.
    bool empty(); //Retorna true se estiver vazia ou falso caso contrário.
    int size(); //Retorna a quantidade de elementos na fila.
};

template <class T>
Fila2<T>::Fila2(){
    tam = 0;
}

/* Método .push() da classe Fila2<> capaz de inserir um elemento no final da fila. */
template <class T>
void Fila2<T>::push(T value){
    pilha.push(value);
    tam++;
}
//retorno: std::stack<T>
//parametros: std::stack<T> &x
template <class T>
void Fila2<T>::remove(){
    if(pilha.size() == 1)
        pilha.pop();
    else {
        T aux = pilha.top();
        pilha.pop();

        remove();
        pilha.push(aux);
    }
}

/* Método .pop() da classe Fila2<> capaz de remover um elemento - recursivamente - do início da fila. */
template <class T>
void Fila2<T>::pop(){
    if(pilha.size() != 0){
        remove();
        tam--;
    }
}

template <class T>
void Fila2<T>::topo(){
    if(pilha.size() == 1)
        top = pilha.top();
    else {
        T aux = pilha.top();
        pilha.pop();

        topo();
        pilha.push(aux);
    }
}

/* Método .front() da classe Fila2<> capaz de retornar o elemento - recursivamente - do início da fila. */
template <class T>
T Fila2<T>::front(){
    if(pilha.size() != 0){
        topo();
        return top;
    }

    return -1;
}

/* Método .empty() da classe Fila2<> capaz de retornar verdadeiro caso a fila esteja vazia
   e retornar falso (0) caso a fila não esteja vazia. */
template <class T>
bool Fila2<T>::empty(){
    return pilha.empty();
}

/* Método .size() da classe Fila2<> capaz de retornar a quantidade de elementos da fila. */
template <class T>
int Fila2<T>::size(){
    return tam;
}

#endif // FILA2_H
