package test.br.com.cwi.crescer.aula7;

import br.com.cwi.crescer.aula7.NaoHouveTraducaoException;
import br.com.cwi.crescer.aula7.PortuguesIngles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortuguesInglesTest {
    @Test
    void getTradutorPortuguesIngles() throws NaoHouveTraducaoException {
        PortuguesIngles portuguesIngles = new PortuguesIngles("você diz sim eu digo não você diz pare e eu digo vai vai vai");
        String fraseTraduzida = portuguesIngles.getTradutorPortuguesIngles();
        assertEquals("you say yes i say no you say stop and i say go go go", fraseTraduzida);
    }
}