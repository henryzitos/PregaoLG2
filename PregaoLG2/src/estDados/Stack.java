package estDados;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  For additional documentation, https://algs4.cs.princeton.edu/13stacks
 *  Section 1.3 of Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

//Classe para a criação de pilhas (stacks) (LIFO)
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;     // Topo da pilha
    private int n;                // Tamanho da pilha

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //Inicializa a pilha vazia
    public Stack() {
        first = null;
        n = 0;
    }

    //Retorna verdadeiro se a pilha estiver vazia
    public boolean isEmpty() {
        return first == null;
    }

    //Retorna o tamanho da pilha
    public int size() {
        return n;
    }

    //Adiciona o elemento a pilha
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    //Remove e retorna o último item adicionado na pilha
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        //Erro que ocorre quando um item é chamado da pilha, mas a pilha está vazia
        Item item = first.item;        // Salva o item pra retornar
        first = first.next;            // Deleta o primeiro nó
        n--;
        return item;                   // Retorna o item salvo anteriormente
    }


    //Retorna sem remover o último item adicionada na pilha
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    //toString para mostrar a pilha
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    //Retorna um iterador para a pilha que itera os itens na ordem LIFO.
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    //O iterador
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        //O próximo item existe?
        public boolean hasNext() {
            return current != null;
        }

        //Retorna o próximo item
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

