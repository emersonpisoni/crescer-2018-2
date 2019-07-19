package br.com.cwi.crescer.aula5.Personagens;

public class Scorpion extends Personagem {

    public Scorpion() {
        super("Scorpion", 4, 10, 0, 0);
    }

    @Override
    public void realizarAtaque(Personagem personagenAlvo) {
        personagenAlvo.receberDano(danoDeAtaque);
    }
}
