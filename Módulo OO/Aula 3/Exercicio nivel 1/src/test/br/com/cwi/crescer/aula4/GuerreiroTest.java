package test.br.com.cwi.crescer.aula4;

import br.com.cwi.crescer.aula4.Guerreiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuerreiroTest {

    @Test
    void subirDeNivel() {
        Guerreiro guerreiro=new Guerreiro();
        guerreiro.subirDeNivel();
        assertEquals(2,guerreiro.getVida());
        assertEquals(2, guerreiro.getPoderDeAtaque());

        guerreiro.subirDeNivel();
        assertEquals(4,guerreiro.getVida());
        assertEquals(4, guerreiro.getPoderDeAtaque());

    }

    @Test
    void treinaNaAcademiaDeEquitacao() {
    }

    @Test
    void treinaNaAcademiaDeEquitacao1() {
    }

    @Test
    void desequipaCavalo() {
    }

    @Test
    void possuiCavalo() {
    }
}