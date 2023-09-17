package datastructures.Arvore;

public class EArvore<T> {
    T valor;
    EArvore<T> esquerda;
    EArvore<T> direita;

    public EArvore(T valor) {
        this.valor = valor;
    }
}
