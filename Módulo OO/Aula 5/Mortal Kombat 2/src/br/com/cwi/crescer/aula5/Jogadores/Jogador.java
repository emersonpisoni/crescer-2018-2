package br.com.cwi.crescer.aula5.Jogadores;

import br.com.cwi.crescer.aula5.Personagens.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nomeDoJogador;
    private List<Personagem> personagens;

    public Jogador() {
        this.personagens = new ArrayList<>();
    }

    public Jogador(String nomeDoJogador, List<Personagem> personagens) {
        this.nomeDoJogador = nomeDoJogador;
        this.personagens = personagens;
    }

    public void adcionarPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public void removerPersonagem(Personagem personagem) {
        this.personagens.remove(personagem);
    }

    public String getNomeDoJogador() {
        return nomeDoJogador;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }


}
