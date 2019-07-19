package br.com.cwi.crescer.aula5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArieteTest {

    @Test
    void atacarCastelo() {
        Ariete ariete = new Ariete("ariete", 200);
        Castelo castelo = new Castelo("castelo", 200, new Muro(10));
        ariete.atacarCastelo(castelo);
        assertEquals(200, castelo.getVidaDoCastelo());
    }

    @Test
    void atacarCasteloSemMuro() {
        Ariete ariete = new Ariete("ariete", 150);
        Castelo castelo = new Castelo("castelo", 200, new Muro(0));
        ariete.atacarCastelo(castelo);
        assertEquals(50, castelo.getVidaDoCastelo());
    }
}