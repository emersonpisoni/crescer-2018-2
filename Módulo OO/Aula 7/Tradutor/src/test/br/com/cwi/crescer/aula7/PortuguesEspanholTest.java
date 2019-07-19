package test.br.com.cwi.crescer.aula7;

import br.com.cwi.crescer.aula7.NaoHouveTraducaoException;
import br.com.cwi.crescer.aula7.PortuguesEspanhol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortuguesEspanholTest {

    @Test
    void getTradutorPortuguesEspanhol() throws NaoHouveTraducaoException {
        PortuguesEspanhol portuguesEspanhol = new PortuguesEspanhol("você diz sim eu digo não você diz pare e eu digo vai vai vai");
        String fraseTraduzida = portuguesEspanhol.getTradutorPortuguesEspanhol();
        assertEquals("usted dice sí yo dice no usted dice detener y yo dice vai vai vai", fraseTraduzida);
    }
}