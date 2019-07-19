package br.com.cwi.crescer.mortalkombat1.Personagens;

public class LiuKang extends Personagem {

    public LiuKang() {
        super("liu Kang", 3, 8, 0, 0);
    }

    @Override
    public void realizarAtaque(Personagem personagenAlvo) {
        personagenAlvo.receberDano(danoDeAtaque);
    }
}
