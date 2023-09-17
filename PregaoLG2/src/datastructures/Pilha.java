package datastructures;

import java.util.*;

public class Pilha<T>{
    private int[] pilha;
    private int tamanhoMaximo;
    private int topo;

    public Pilha(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.pilha = new int[tamanhoMaximo];
        this.topo = -1;
    }

    public void empilha(int elemento) {
        if (cheia()) {
            System.out.println("A pilha está cheia.");
        } else {
            // topo++;
            pilha[++topo] = elemento;
        }
    }

    public int desempilha() {
        if (vazia()) {
            System.out.println("A pilha está vazia.");
            return -1;
        } else {
            int elemento = pilha[topo];
            topo--;
            return elemento;
        }
    }

    public int topo() {
        if (vazia()) {
            System.out.println("A pilha está vazia.");
            return -1;
        } else {
            return pilha[topo];
        }
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == tamanhoMaximo - 1;
    }

    public int tamanho() {
        return topo + 1;
    }
}
