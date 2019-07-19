package test.br.com.cwi.crescer.mortalkombat1;

import br.com.cwi.crescer.mortalkombat1.Jogadores.Jogador;
import br.com.cwi.crescer.mortalkombat1.Partida.Partida;
import br.com.cwi.crescer.mortalkombat1.Personagens.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartidaTest {

    @Test
    void iniciarBatalha() {
        String nomeDoJogador1 = "Fulano";
        String nomeDoJogador2 = "Ciclano";

        List<Personagem> personagens1 = new ArrayList<>();
        personagens1.add(new Raiden());
        personagens1.add(new LiuKang());
        personagens1.add(new ShaoKahn());

        List<Personagem> personagens2 = new ArrayList<>();
        personagens2.add(new SoniaBlade());
        personagens2.add(new SubZero());
        personagens2.add(new Scorpion());

        Jogador jogador1 = new Jogador(nomeDoJogador1, personagens1);
        Jogador jogador2 = new Jogador(nomeDoJogador2, personagens2);

        Partida partida = new Partida(jogador1, jogador2);
        partida.iniciarBatalha();

        assertEquals(nomeDoJogador1, partida.getPerdedor());
        assertEquals(nomeDoJogador2, partida.getVencedor());
    }
}