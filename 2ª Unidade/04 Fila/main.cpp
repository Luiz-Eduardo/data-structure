#include <iostream>
#include "fila1.h"
#include "fila2.h"

using namespace std;

int main(){
    Fila1<char> fila;

    cout << "\t\tTESTE DA FILA UTILIZANDO DUAS PILHAS\n\n";
    fila.push('a');
    fila.push('b');
    fila.push('c');
    fila.push('d');
    fila.push('e');

    cout << "O tamanho da fila é: " << fila.size() << endl;
    cout << "O primeiro elemento removido é: " << fila.poll() << endl;
    fila.pop(); //Remove o segundo elemento da fila 'b'.
    while(!fila.empty()){
        cout << "O elemento que está na frente da fila é: " << fila.front() << endl;
        fila.pop();
    }

    //Testando caso a fila esteja vazia e queira remover e retornar um elemento, retorna-se um elemento -1 do tipo size_t.
    cout << "Se a fila estiver vazia e eu quero retornar e remover um elemento: " << (int) fila.poll() << endl;


    cout << "\n\n\t\tTESTE DA FILA UTILIZANDO UMA PILHA E UMA VARIÁVEL\n\n";

    Fila2<int> queue;

    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.push(5);

    cout << "O tamanho da fila é: " << queue.size() << endl;
    while(!queue.empty()){
        cout << "O elemento que está na frente da fila é: " << queue.front() << endl;
        queue.pop();
    }

    return 0;
}
