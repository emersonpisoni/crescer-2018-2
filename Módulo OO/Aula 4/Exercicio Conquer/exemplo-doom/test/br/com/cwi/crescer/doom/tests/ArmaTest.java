package br.com.cwi.crescer.doom.tests;

import br.com.cwi.crescer.doom.BFG;
import br.com.cwi.crescer.doom.Demonio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {

    @Test
    void exemploDaAula() {

        BFG bfg = new BFG();

        Demonio demonio = new Demonio();

        bfg.atirar(demonio);
    }
}