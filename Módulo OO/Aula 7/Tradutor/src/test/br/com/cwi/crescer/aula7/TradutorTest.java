package test.br.com.cwi.crescer.aula7;

import br.com.cwi.crescer.aula7.InglesEspanhol;
import br.com.cwi.crescer.aula7.NaoHouveTraducaoException;
import br.com.cwi.crescer.aula7.PortuguesEspanhol;
import br.com.cwi.crescer.aula7.PortuguesIngles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradutorTest {

    @Test
    void getTradutorInglesEspanhol() {
        InglesEspanhol inglesEspanhol = new InglesEspanhol("you");
        String fraseTraduzida = inglesEspanhol.getTradutorInglesEspanhol();

        assertEquals("usted", fraseTraduzida);
    }

    @Test
    void testar() throws NaoHouveTraducaoException {
        PortuguesIngles portuguesIngles = new PortuguesIngles("eu");
        System.out.println(portuguesIngles.getTradutorPortuguesIngles());
    }
}