package br.com.cwi.crescer.mortalkombat1.Personagens;

public class SubZero extends Personagem {


    public SubZero() {
        super("Sub Zero", 3, 20, 0, 0);
    }

    @Override
    public void receberDano(int danoDeAtaque) {
        super.receberDano(danoDeAtaque);
        super.quantidadeDeVezesQueAtacou ++;
        if(super.quantidadeDeVezesQueAtacou == 3 ) {
            super.quantidadeDeVezesQueAtacou = 0;
            aumentarDanoSubZero();
        }
    }

    public void aumentarDanoSubZero(){
        super.danoDeAtaque ++;
    }

    @Override
    public void realizarAtaque(Personagem personagenAlvo) {
        personagenAlvo.receberDano(danoDeAtaque);
    }


}
