package datastructures.Lista;

class ELista<T> {
    private T valor;
    private ELista<T> next;

    public ELista(T valor) {
        this.valor = valor;
        this.next = null;
    }
}

