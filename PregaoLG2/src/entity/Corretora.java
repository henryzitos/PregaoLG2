package entity;

import estDados.*;
/*
A classe Corretora representa uma corretora de valores mobiliários. Uma corretora facilita
a compra e venda de ativos financeiros em nome de seus clientes (investidores). Esta classe
mantém uma lista de clientes e fornece métodos para adicionar novos clientes à corretora.
*/
public class Corretora {
    private int idCorretora = 0;
    private String nome;                //Nome da corretora
    private Vetor<Investidor> clientes; //Lista dos clientes que investem com essa corretora
    private Custodiante custodiante;

    private static int idBase = 1;

    public Corretora(String nome, Custodiante custodiante) {
        if (custodiante == null) {
            throw new IllegalArgumentException("O custodiante não pode ser nulo.");
        }
        this.idCorretora = idBase;
        this.nome = nome;
        this.clientes = new Vetor<Investidor>(1000);
        this.custodiante = custodiante;
        custodiante.addCorretora(this);
        idBase++;
    }

    public void adicionarCliente(Investidor cliente) {
        clientes.adicionar(cliente);
    }

    @Override
    public String toString() {
        return "Corretora{" +
                "idCorretora=" + idCorretora +
                ", nome='" + nome + '\'' +
                ", clientes=" + clientes +
                ", custodiante=" + custodiante +
                '}';
    }
}
