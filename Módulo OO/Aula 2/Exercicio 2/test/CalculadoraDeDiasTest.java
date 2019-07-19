import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDiasTest {

    @Test
    void segundosParaDias() {

        CalculadoraDeDias calculadora = new CalculadoraDeDias();

        String resultado = calculadora.segundosParaDias(99999);

        assertEquals("01 dias 03:46:39", resultado);
    }
}