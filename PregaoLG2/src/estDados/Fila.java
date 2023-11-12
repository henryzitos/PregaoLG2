package estDados;

//Classe para criação de filas (queue) (FIFO)
public class Fila<T> {
    private Object[] elementos;
    private int primeiro;
    private int ultimo;

    //Construtor da fila
    public Fila(int tamanho) {
        elementos = new Object[tamanho];
        primeiro = 0;
        ultimo = -1;
    }

    //Função para inserir um elemento na fila
    public void insere(T elemento) {
        if (isCheia()) {
            throw new IllegalStateException("Fila cheia! Não é possível adicionar mais elementos.");
        } else {
            ultimo = (ultimo + 1) % elementos.length;
            elementos[ultimo] = elemento;
        }
    }

    //Função para remover um elemento na fila
    public T remove() {
        if (isVazia()) {
            throw new IllegalStateException("Fila vazia!");
        } else {
            T elemento = (T) elementos[primeiro];
            primeiro = (primeiro + 1) % elementos.length;
            return elemento;
        }
    }

    //Função que verifica se a fila está vazia.
    public boolean isVazia() {
        return primeiro > ultimo;
    }

    //Função que verifica se a fila está cheia.
    public boolean isCheia() {
        return ultimo == elementos.length - 1;
    }

    public T[] getElementos() {
        //Retorna uma cópia do array para evitar a modificação direta
        T[] copia = (T[]) new Object[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            copia[i] = (T) elementos[i];
        }
        return copia;
    }
}
