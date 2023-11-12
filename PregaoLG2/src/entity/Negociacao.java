package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Negociacao {
    private LocalDateTime data;
    private int quantidade;
    private double preco;

    public Negociacao(LocalDateTime data, int quantidade, double preco) {
        this.data = data;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}

