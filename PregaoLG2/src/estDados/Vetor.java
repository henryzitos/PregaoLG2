package estDados;

import java.util.Arrays;
import java.util.Iterator;

//Classe para criação de vetores/listas
public class Vetor<T> implements Iterable<T> {
    private int tamanho;
    private Object[] elementos;

    //Construtor do vetor
    public Vetor(int capacidade) {
        this.tamanho = 0;
        this.elementos = new Object[capacidade];
    }

    //Verifica se o vetor está vazio
    public boolean taVazio() {
        return tamanho == 0;
    }

    //Verifica se o vetor está cheio
    public boolean taCheio() {
        return tamanho == elementos.length;
    }

    //Adiciona um elemento no vetor, antes fazendo uma verificação (garantirCapacidade())
    public void adicionar(T elemento) {
        garantirCapacidade();
        elementos[tamanho++] = elemento;
    }

    //Adiciona um elemento em um índice específico no vetor
    public void adicionar(T elemento, int indice) {
        verificarIndiceValidoParaInsercao(indice);
        garantirCapacidade();

        //Move os elementos para a DIREITA a partir do índice para abrir espaço
        System.arraycopy(elementos, indice, elementos, indice + 1, tamanho - indice);

        elementos[indice] = elemento;
        tamanho++;
    }

    //Função para remover um elemento a partir do índice dele
    public void remover(int indice) {
        verificarIndiceValido(indice);

        //Move os elementos para a ESQUERDA a partir do índice
        System.arraycopy(elementos, indice + 1, elementos, indice, tamanho - indice - 1);

        elementos[--tamanho] = null;
    }

    //Função para remover um elemento específico do vetor
    public void removerElemento(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                remover(i);
                return;
            }
        }
        throw new RuntimeException("O item não foi encontrado!");
    }

    //Função para garantir a capacidade do vetor
    private void garantirCapacidade() {
        if (taCheio()) {
            int novaCapacidade = elementos.length * 2;
            elementos = Arrays.copyOf(elementos, novaCapacidade);
        }
    }

    //Função para verificar se o índice é válido (apenas)
    private void verificarIndiceValido(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora do alcance!");
        }
    }

    //Função para verificar se o índice é válido PARA INSERÇÃO
    private void verificarIndiceValidoParaInsercao(int indice) {
        if (indice < 0 || indice > tamanho) {
            throw new IndexOutOfBoundsException("Índice de inserção fora do alcance!");
        }
    }

    //toString para imprimir o vetor
    /*@Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementos, tamanho));
    }*/

    //Mostra o tamanho do vetor
    public int tamanho() {
        return tamanho;
    }

    //Mostra a capacidade do vetor
    public int capacidade() {
        return elementos.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indiceAtual = 0;

            @Override
            public boolean hasNext() {
                return indiceAtual < tamanho;
            }

            @Override
            public T next() {
                return (T) elementos[indiceAtual++];
            }
        };
    }
}
