package test.br.com.cwi.crescer.mortalkombat1;

import br.com.cwi.crescer.mortalkombat1.Personagens.Raiden;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaidenTest {
    @Test
    void aumentarVidaDoRaidenQuandoReceberDoisAtaques() {
        Raiden raiden = new Raiden();
        raiden.receberDano(1);
        raiden.receberDano(1);
        assertEquals(9, raiden.getVida());
    }

}