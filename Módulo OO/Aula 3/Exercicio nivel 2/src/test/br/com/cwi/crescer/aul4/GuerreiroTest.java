package test.br.com.cwi.crescer.aul4;

import br.com.cwi.crescer.aula4.Guerreiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuerreiroTest {

    @Test
    void subirDeNivel() {
        Guerreiro guerreiro = new Guerreiro();
        guerreiro.subirDeNivel();
        assertEquals(2, guerreiro.getVida());
        assertEquals(2, guerreiro.getPoderDeAtaque());
        assertEquals(2, guerreiro.getNivel());

        guerreiro.subirDeNivel();
        assertEquals(4, guerreiro.getVida());
        assertEquals(4, guerreiro.getPoderDeAtaque());
        assertEquals(3, guerreiro.getNivel());
    }

    @Test
    void subirDeNivelComCavalo() {
        Guerreiro guerreiro = new Guerreiro();
        guerreiro.treinaNaAcademiaDeEquitacao();
        guerreiro.subirDeNivel();
        guerreiro.subirDeNivel();
        assertEquals(4, guerreiro.getVida());
        assertEquals(4, guerreiro.getPoderDeAtaque());
    }

    @Test
    void treinarAcademiaPaladinos() {
    }

}