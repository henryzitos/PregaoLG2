package entity;

/*
A classe AcaoPreferencial é outra subclasse de Acao e representa ações preferenciais.
Ações preferenciais geralmente têm a vantagem de receber dividendos fixos antes das ações ordinárias
e, em algumas situações, podem ter direitos especiais em caso de liquidação da empresa.
Esta classe inclui atributos e métodos relacionados ao cálculo de dividendos.
*/

public class AP extends Acao {
    private double dividendoFixo;

    public AP(String simbolo, double preco) {
        super("Ação Preferencial", simbolo, preco);
    }

    public double calcularDividendos() {
        // Lógica para calcular o valor dos dividendos
        return dividendoFixo;
    }
}
