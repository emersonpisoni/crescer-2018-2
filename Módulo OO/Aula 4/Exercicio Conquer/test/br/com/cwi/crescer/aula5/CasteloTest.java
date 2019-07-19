package br.com.cwi.crescer.aula5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasteloTest {

    @Test
    void casteloDestruido() {
        Castelo castelo = new Castelo("castle",0, new Muro(200));
        assertTrue(castelo.casteloDestruido());
    }

    @Test
    void receberDanoNoCasteloPorArieteComPontaDeFerro() {
        Castelo castelo = new Castelo("Castlevania", 5000, new Muro(0));
        ArieteComPontaDeFerro arieteComPontaDeFerro = new ArieteComPontaDeFerro("arietao", 1000);
        arieteComPontaDeFerro.atacarCastelo(castelo);
        assertEquals(3000, castelo.getVidaDoCastelo());
    }

    @Test
    void receberDanoNoCasteloPorAriete() {
        Castelo castelo = new Castelo("Castlemania", 5000, new Muro(0));
        Ariete ariete = new Ariete("arietao", 1000);
        ariete.atacarCastelo(castelo);
        assertEquals(4000, castelo.getVidaDoCastelo());
    }

    @Test
    void receberDanoDaCatapulta() {
        Castelo castelo = new Castelo("Castlebania", 5000, new Muro(0));
        Catapulta catapulta = new Catapulta("catapa", 1000, 3);
        catapulta.atacarCastelo(castelo);
        assertEquals(3994, castelo.getVidaDoCastelo());
    }

    @Test
    void getVidaDoCastelo() {
        Castelo castelo = new Castelo("Castle", 950, new Muro(100));
        assertEquals(950, castelo.getVidaDoCastelo());
    }
}