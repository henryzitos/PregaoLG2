package entity;

import datastructures.*;
import java.util.*;

public class Investidor {
    private int id;
    private String nome;
    private ArrayList<Carteira> carteiras;
    private double saldo;

    public Investidor(String nome, int id, List<Carteira> carteiras) {
        this.nome = nome;
        this.id = id;
        this.carteiras = new ArrayList<>();
        this.setSaldo(saldo);
    }

    // Getters e setters para nome e cpf
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0.0){
            System.out.println("Saldo inválido | Negativo");
        }
        this.saldo = saldo;
    }

    // Métodos relacionados à carteira
    public void adicionarAtivo(Ativo ativo) {
        carteiras.adicionarAtivo(ativo);
    }

    public void removerAtivo(Ativo ativo) {
        carteiras.removerAtivo(ativo);
    }

    public double calcularValorTotalCarteira() {
        return carteiras.calcularValorTotal();
    }

    @Override
    public String toString() {
        return "Investidor [nome=" + nome + ", id=" + id + ", carteiras=" + carteiras + "]";
    }
}
