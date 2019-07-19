package test.br.com.cwi.crescer;

import br.com.cwi.crescer.aula5.Jogadores.Maquina;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class MaquinaTest {

    @Test
    void adicionarPersonagensAleatoriosParaMaquina() {
        Maquina maquina = new Maquina("Maquina", 17);
        maquina.adicionarPersonagensParaMaquina();
        assertEquals(17, maquina.getPersonagens().size());
        assertNotEquals(18, maquina.getPersonagens().size());
    }
}