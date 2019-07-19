package br.com.cwi.crescer.mortalkombat1.Personagens;

public class Raiden extends Personagem {

    public Raiden() {
        super("Raiden", 2, 10, 0, 0);
    }

    @Override
    public void realizarAtaque(Personagem personagenAlvo) {
        personagenAlvo.receberDano(danoDeAtaque);
    }

    @Override
    public void receberDano(int danoDeAtaque) {
        super.receberDano(danoDeAtaque);
        super.quantidadeDeVezesQueRecebeuDano++;
        if(quantidadeDeVezesQueRecebeuDano == 2){
            super.vida++;
        }
    }
}
