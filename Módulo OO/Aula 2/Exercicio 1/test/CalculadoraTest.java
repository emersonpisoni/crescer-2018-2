import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void somar() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.somar(1, 2);

        assertEquals(3, resultado);
    }

    @Test
    void subtracao() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.subtracao(4, 1);

        assertEquals(3, resultado);
    }

    @Test
    void dividir() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.dividir(10, 2);

        assertEquals(5, resultado);
    }

    @Test
    void multiplicar() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicar(5, 5);

        assertEquals(25, resultado);
    }
}