package entity;

/*
A classe AcaoOrdinaria é uma subclasse de Acao e representa especificamente ações ordinárias.
Ações ordinárias geralmente concedem direito a voto nas assembleias de acionistas,
permitindo que os detentores participem das decisões importantes da empresa.
Esta classe inclui um atributo adicional para indicar se a ação ordinária possui direito de voto
e métodos associados a esse direito.
*/
public class AO extends Acao {
    private boolean direitoVoto;

    public AO(String simbolo, double preco) {
        super("Ação Ordinária", simbolo, preco);
    }

    public boolean temDireitoVoto() {
        return direitoVoto;
    }

    public void votar(boolean decisao) {
        // Lógica para permitir que o acionista vote
    }
}
