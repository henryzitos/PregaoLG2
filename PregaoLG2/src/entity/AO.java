package entity;

public class AO extends Ativo {
    private int quantidade;

    public AO(String codigo, String nome, double valorAtual, int quantidade) {
        super(codigo, nome, valorAtual);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "AcaoOrdinaria [codigo=" + getCodigo() + ", nome=" + getNome() + ", valorAtual=" + getValorAtual()
                + ", quantidade=" + quantidade + "]";
    }
}
