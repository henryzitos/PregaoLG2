package entity;

public class Ativo {
    private String codigo;
    private String nome;
    private double valorAtual;

    public Ativo(String codigo, String nome, double valorAtual) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorAtual = valorAtual;
    }

    // Getters e setters para código, nome e valorAtual
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    @Override
    public String toString() {
        return "Ativo [codigo=" + codigo + ", nome=" + nome + ", valorAtual=" + valorAtual + "]";
    }
}

