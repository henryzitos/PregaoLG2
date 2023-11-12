package main;

import entity.*;
import docs.*;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Custodiante custodiante = new Custodiante("Caixa Econômica Federal");

        Corretora corretora1 = new Corretora("XP Investimentos", custodiante);
        Corretora corretora2 = new Corretora("Toro Investimentos", custodiante);

        Investidor investidor1 = new Investidor("Henry", 2500, corretora1);
        Investidor investidor2 = new Investidor("Arthur", 1000, corretora2);

        Acao acao1 = new AO("ABEV3", 100);
        Acao acao2 = new AP("PETR4", 1500);
        Acao acao3 = new FII("ELDO11B", 500);

        investidor1.comprarAcao(acao2, 1);
        investidor1.comprarAcao(acao2, 1);
        investidor1.comprarAcao(acao3, 1);
        investidor2.comprarAcao(acao1, 10);

        investidor2.venderAcao(acao2, 1);
        investidor2.venderAcao(acao1, 5);

        investidor1.registraNoArquivo(investidor1);
        investidor2.registraNoArquivo(investidor2);
    }
}