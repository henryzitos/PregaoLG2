package entity;

import estDados.Vetor;
/*
A classe Carteira representa a carteira de ativos de um investidor. Ela mantém um mapa de ativos
(ações) e suas quantidades associadas na carteira. A classe oferece métodos para adicionar e remover
 ativos da carteira, calcular o valor total da carteira e exibir seu conteúdo.
*/
public class Carteira {
    private Vetor<VendaAcao> acoes;

    public Carteira() {
        this.acoes = new Vetor<VendaAcao>(1000);
    }

    public void adicionarAcao(VendaAcao vendaAcao) {
        acoes.adicionar(vendaAcao);
    }

    public void atualizaRemoveAcao(VendaAcao vendaAcaoComparacao) {
        for (VendaAcao vendaAcaoAtualizar : acoes) {
            if (vendaAcaoComparacao.getAcao() == vendaAcaoAtualizar.getAcao()) {
                if (vendaAcaoComparacao.getQuantidade() == vendaAcaoAtualizar.getQuantidade()) {
                    acoes.removerElemento(vendaAcaoAtualizar);
                } else if (vendaAcaoComparacao.getQuantidade() < vendaAcaoAtualizar.getQuantidade()) {
                    acoes.removerElemento(vendaAcaoComparacao);
                    acoes.adicionar(vendaAcaoAtualizar);
                }
            }
        }
    }

    public boolean temAcaoQuantidade(Acao acao, int quantidade) {
        VendaAcao vendaAcaoComparacao = new VendaAcao(acao, quantidade);
        for (VendaAcao vendaAcao : acoes) {
            if (vendaAcaoComparacao.getAcao() == vendaAcao.getAcao()){
                if(vendaAcaoComparacao.getQuantidade() <= vendaAcaoComparacao.getQuantidade()){
                    vendaAcao.setQuantidade(vendaAcaoComparacao.getQuantidade());
                    return true;
                }
            }
        }
        return false;
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        // Lógica para calcular o valor total da carteira
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Carteira{" +
                "acoes=" + acoes +
                '}';
    }
}
