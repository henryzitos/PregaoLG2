package datastructures.Arvore;

import java.lang.Comparable;

public class Arvore<T extends Comparable<T>>{
    private EArvore<T> raiz;

    public void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    } // Passa a raiz

    private EArvore<T> inserirRecursivo(EArvore<T> no, T valor) {
        if (no == null) {
            return new EArvore<>(valor);
        }

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    } // Cria um novo nó através de comparações

    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(EArvore<T> no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }
}
