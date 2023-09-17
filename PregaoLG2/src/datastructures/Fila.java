package datastructures;

import java.util.*;

public class Fila<T> {
    private LinkedList<T> lista = new LinkedList<T>();

    public void enqueue(T item) {
        lista.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return lista.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return lista.getFirst();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}
