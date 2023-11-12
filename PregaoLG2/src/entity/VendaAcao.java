package entity;

public class VendaAcao {
    private Acao acao;
    private int quantidade;

    public VendaAcao(Acao acao, int quantidade) {
        this.acao = acao;
        this.quantidade = quantidade;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaAcao vendaAcao = (VendaAcao) o;
        return quantidade == vendaAcao.quantidade && acao.equals(vendaAcao.acao);
    }

    @Override
    public String toString() {
        return "Ação: " + acao.getSimbolo() + ", Quantidade: " + quantidade;
    }
}
