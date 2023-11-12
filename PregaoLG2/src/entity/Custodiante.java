package entity;

import estDados.Vetor;

/*
A classe Custodiante representa uma entidade responsável pela custódia de ativos financeiros.
O custodiante atua como detentor seguro dos ativos, garantindo sua integridade. Esta classe
mantém informações sobre o custodiante e inclui métodos relacionados à sua função no contexto
do projeto.
*/
public class Custodiante {
    private String nome;                 //Nome do custodiante das ações
    private Vetor<Corretora> corretoras; //A lista de corretoras que trabalham com este custodiante

    public Custodiante(String nome) {
        this.nome = nome;
        this.corretoras = new Vetor<Corretora>(100);
    }

    public void addCorretora(Corretora corretora){
        corretoras.adicionar(corretora);
    }

    @Override
    public String toString() {
        return "Custodiante{" +
                "nome='" + nome + '\'' +
                ", corretoras=" + corretoras +
                '}';
    }
}
