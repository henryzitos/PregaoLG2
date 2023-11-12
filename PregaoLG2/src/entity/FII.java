package entity;

/*
A classe FundoInvestimentoImobiliario é uma subclasse de Acao e representa fundos de investimento
imobiliário (FIIs). Os FIIs são veículos de investimento que possuem e operam empreendimentos
imobiliários, distribuindo os rendimentos aos investidores. Esta classe inclui atributos específicos
de FIIs, como o patrimônio líquido, e métodos relacionados ao cálculo de rendimentos mensais.
*/
public class FII extends Acao {
    private double patrimonioLiquido;

    public FII(String simbolo, double preco) {
        super("FII", simbolo, preco);
    }

    /*public double calcularRendimentoMensal() {
        // Lógica para calcular o rendimento mensal do fundo
        return patrimonioLiquido * taxaDeRendimento;
    }*/
}
