package entity;

import estDados.Stack;
import estDados.Vetor;
import java.time.*;
import java.util.List;

/*
A classe Acao representa uma ação genérica no contexto do mercado financeiro.
As ações são instrumentos financeiros que representam a propriedade de uma parte
de uma empresa. Esta classe contém informações básicas sobre uma ação, como o
tipo (Ação Ordinária, Ação Preferencial, FII), símbolo exclusivo, histórico de negociações
e o custodiante responsável.
*/
public class Acao {
    private String tipo;
    private String simbolo;
    private Stack<Negociacao> historicoDeNegociacoes;
    private double preco = 0;

    public Acao(String tipo, String simbolo, double preco) {
        this.tipo = tipo;
        this.simbolo = simbolo;
        this.preco = preco;
        this.historicoDeNegociacoes = new Stack<Negociacao>();
    }

    public void negociar(Acao acao, int quantidade, double preco){
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        Negociacao negociacao = new Negociacao(dataHoraAtual, quantidade, preco);
        historicoDeNegociacoes.push(negociacao);
    }

    public void adicionarNegociacao(Negociacao negociacao) {
        historicoDeNegociacoes.push(negociacao);
    }

    public void exibirHistorico() {
        System.out.println("Histórico de negociações para " + simbolo + ":");
        for (Negociacao negociacao : historicoDeNegociacoes) {
            System.out.println("Data: " + negociacao.getData() + ", Quantidade: " + negociacao.getQuantidade() +
                    ", Preço: R$" + negociacao.getPreco());
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Stack<Negociacao> getHistoricoDeNegociacoes() {
        return historicoDeNegociacoes;
    }

    public void setHistoricoDeNegociacoes(Stack<Negociacao> historicoDeNegociacoes) {
        this.historicoDeNegociacoes = historicoDeNegociacoes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Acao{" +
                "tipo='" + tipo + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", historicoDeNegociacoes=" + historicoDeNegociacoes +
                ", preco=" + preco +
                '}';
    }
}
