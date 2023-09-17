package entity;

public class FII extends Ativo {
    private int quantidadeCotas;

    public FII(String codigo, String nome, double valorAtual, int quantidadeCotas) {
        super(codigo, nome, valorAtual);
        this.quantidadeCotas = quantidadeCotas;
    }

    public int getQuantidadeCotas() {
        return quantidadeCotas;
    }

    public void setQuantidadeCotas(int quantidadeCotas) {
        this.quantidadeCotas = quantidadeCotas;
    }

    @Override
    public String toString() {
        return "FundoInvestimentoImobiliario [codigo=" + getCodigo() + ", nome=" + getNome() + ", valorAtual="
                + getValorAtual() + ", quantidadeCotas=" + quantidadeCotas + "]";
    }
}