package test.br.com.cwi.crescer;

import br.com.cwi.crescer.aula5.Jogadores.Jogador;
import br.com.cwi.crescer.aula5.Partida.Partida;
import br.com.cwi.crescer.aula5.Personagens.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PartidaTest {

    @Test
    void iniciarBatalhaComDoisJogadores() {
        String nomeJogador1 = "Emerson";
        String nomeJogador2 = "João";

        List<Personagem> personagens1 = new ArrayList<>();
        personagens1.add(new Raiden());
        personagens1.add(new LiuKang());
        personagens1.add(new ShaoKahn());

        List<Personagem> personagens2 = new ArrayList<>();
        personagens2.add(new SoniaBlade());
        personagens2.add(new SubZero());
        personagens2.add(new Scorpion());

        Jogador jogador1 = new Jogador(nomeJogador1, personagens1);
        Jogador jogador2 = new Jogador(nomeJogador2, personagens2);

        Partida partida = new Partida(jogador1, jogador2);

        partida.iniciarBatalha();

        assertEquals(nomeJogador1, partida.getPerdedor());
        assertNotEquals(nomeJogador2, partida.getPerdedor());
    }

    @Test
    void iniciarBatalhaVSMaquina() {
        String nomeDoJogador = "Emerson";
        String nomeDaMaquina = "Maquina";

        List<Personagem> personagens1 = new ArrayList<>();
        personagens1.add(new Raiden());
        personagens1.add(new LiuKang());
        personagens1.add(new ShaoKahn());

        Jogador jogador = new Jogador(nomeDoJogador, personagens1);

        Partida partida = new Partida(jogador);

        partida.iniciarBatalhaVSMaquina();

        assertEquals(nomeDaMaquina, partida.getPerdedor());
        assertNotEquals(nomeDoJogador, partida.getPerdedor());
    }

}