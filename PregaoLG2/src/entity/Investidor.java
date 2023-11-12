package entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
A classe Investidor representa um investidor no mercado financeiro.
Ela inclui atributos como código, nome, saldo e uma carteira de ativos.
A classe oferece métodos para realizar transações de compra e venda de ativos,
refletindo as ações típicas de um investidor no mercado.
*/
public class Investidor {
    private int idInvestidor = 0;
    private String nome;
    private double saldo;
    private Carteira carteiraDeAcoes;
    private Corretora corretora;

    private static int idBase = 1;

    public Investidor(String nome, double saldo, Corretora corretora) {
        if (corretora == null) {
            throw new IllegalArgumentException("A corretora não pode ser nula.");
        }
        this.idInvestidor = idBase;
        this.nome = nome;
        this.saldo = saldo;
        this.corretora = corretora;
        this.carteiraDeAcoes = new Carteira();
        corretora.adicionarCliente(this);
        idBase++;
    }

    public void comprarAcao(Acao acao, int quantidade) {
        double precoTotal = acao.getPreco() * quantidade;
        if (precoTotal <= saldo) {
            // A compra pode ser realizada.
            saldo = saldo - precoTotal;
            VendaAcao vendaAcao = new VendaAcao(acao, quantidade);
            String pedido = vendaAcao.toString();
            carteiraDeAcoes.adicionarAcao(vendaAcao);
            System.out.println("A compra da ação " + acao.getSimbolo() + " foi realizada com sucesso. ");
            System.out.println("A ação foi adicionada na carteira de " + nome);
            System.out.println(pedido);
        } else {
            // A compra não pode ser realizada devido ao saldo insuficiente.
            System.out.println(nome + ", a compra dessa ação não pode ser realizada devido ao saldo insuficiente.");
        }
    }

    public void venderAcao(Acao acao, int quantidade) {
        if (carteiraDeAcoes.temAcaoQuantidade(acao, quantidade)) {
            VendaAcao vendaAcaoComparacao = new VendaAcao(acao, quantidade);
            String pedido = vendaAcaoComparacao.toString();
            // A venda pode ser realizada.
            double valorDaVenda = acao.getPreco() * quantidade;
            saldo = saldo + valorDaVenda;
            carteiraDeAcoes.atualizaRemoveAcao(vendaAcaoComparacao);
            if(quantidade == 1){
                System.out.println("A venda da ação " + acao.getSimbolo() + " foi realizada com sucesso. ");
                System.out.println(nome + " recebeu R$" + valorDaVenda + " pela venda dessa ação.");
            } else {
                System.out.println("A venda das cotas da ação " + acao.getSimbolo() + " foram realizadas com sucesso. ");
                System.out.println(nome + " recebeu R$" + valorDaVenda + " pela venda dessas cotas.");
            }
            System.out.println(pedido);
        } else {
            // A venda não pode ser realizada devido à quantidade insuficiente de ações, ou posse de tal, na carteira.
            System.out.println(nome + ", a venda dessa ação não pode ser realizada devido à quantidade insuficiente na carteira ou não estar em posse de tal.");
        }
    }

    public int getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(int idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Carteira getCarteiraDeAcoes() {
        return carteiraDeAcoes;
    }

    public void setCarteiraDeAcoes(Carteira carteiraDeAcoes) {
        this.carteiraDeAcoes = carteiraDeAcoes;
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public static int getIdBase() {
        return idBase;
    }

    public static void setIdBase(int idBase) {
        Investidor.idBase = idBase;
    }

    public void registraNoArquivo(Investidor investidor) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("registros\\Registro.txt", true));
            writer.write(investidor.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Investidor{" +
                "idInvestidor=" + idInvestidor +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", carteiraDeAcoes=" + carteiraDeAcoes +
                ", corretora=" + corretora +
                '}';
    }
}
