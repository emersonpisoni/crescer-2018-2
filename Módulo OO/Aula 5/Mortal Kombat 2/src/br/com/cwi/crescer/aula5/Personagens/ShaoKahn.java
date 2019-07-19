package br.com.cwi.crescer.aula5.Personagens;

public class ShaoKahn extends Personagem {

    public ShaoKahn() {
        super("ShaoKahn", 1, 30, 0, 0);
    }

    @Override
    public void realizarAtaque(Personagem personagemAlvo) {
        personagemAlvo.receberDano(danoDeAtaque);
        super.danoDeAtaque++;
    }

}


