package entity;

import java.util.*;

public class Carteira {
    private List<Ativo> ativos;

    public Carteira() {
        ativos = new ArrayList<>();
    }

    public void adicionarAtivo(Ativo ativo) {
        ativos.add(ativo);
    }

    public void removerAtivo(Ativo ativo) {
        ativos.remove(ativo);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Ativo a : ativos) {
            valorTotal += a.getValorAtual();
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Carteira [ativos=" + ativos + "]";
    }
}

