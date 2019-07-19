package test.br.com.cwi.crescer;

import br.com.cwi.crescer.aula5.Personagens.ShaoKahn;
import br.com.cwi.crescer.aula5.Personagens.SubZero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShaoKahnTest {

    @Test
    void testaAumentarDanoDoShaoKhanQuandoEleAtaca() {
        ShaoKahn shaoKahn = new ShaoKahn();
        SubZero subZero = new SubZero();
        shaoKahn.realizarAtaque(subZero);
        assertEquals(2, shaoKahn.getDanoDeAtaque());

    }

}