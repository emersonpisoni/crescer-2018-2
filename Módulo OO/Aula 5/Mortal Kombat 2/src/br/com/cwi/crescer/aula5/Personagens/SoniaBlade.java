package br.com.cwi.crescer.aula5.Personagens;

public class SoniaBlade extends Personagem {

    public SoniaBlade() {
        super("Sonia Blade", 10, 10,0, 0);
    }

    @Override
    public void realizarAtaque(Personagem personagenAlvo) {
        personagenAlvo.receberDano(danoDeAtaque);
    }
}
