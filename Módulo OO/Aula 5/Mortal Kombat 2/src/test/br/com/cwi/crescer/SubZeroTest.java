package test.br.com.cwi.crescer;

import br.com.cwi.crescer.aula5.Personagens.SubZero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubZeroTest {

    @Test
    void testaAumentarDanoQuandoReceberDano() {
        SubZero subZero = new SubZero();
        subZero.receberDano(1);
        subZero.receberDano(1);
        subZero.receberDano(1);
        assertEquals(4, subZero.getDanoDeAtaque());
    }

}