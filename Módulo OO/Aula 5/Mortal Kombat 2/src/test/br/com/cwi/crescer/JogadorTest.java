package test.br.com.cwi.crescer;

import br.com.cwi.crescer.aula5.Jogadores.Jogador;
import br.com.cwi.crescer.aula5.Personagens.ShaoKahn;
import br.com.cwi.crescer.aula5.Personagens.SubZero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JogadorTest {



    @Test
    void adicionarERemoverPersonagemNaLista() {
        Jogador jogador = new Jogador();

        ShaoKahn shaoKahn = new ShaoKahn();
        SubZero subZero = new SubZero();
        jogador.adcionarPersonagem(shaoKahn);
        jogador.adcionarPersonagem(subZero);

        Jogador jogador2 = new Jogador();
        jogador2.adcionarPersonagem(new ShaoKahn());
        jogador2.adcionarPersonagem(new SubZero());

        assertEquals(2, jogador.getPersonagens().size());

        jogador.removerPersonagem(shaoKahn);
        assertEquals(1, jogador.getPersonagens().size());

    }

}