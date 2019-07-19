//package br.com.cwi.crescer.test;
//
//import br.com.cwi.crescer.domain.carteira.CarteiraHabilitacao;
//import br.com.cwi.crescer.domain.carteira.Categoria;
//import br.com.cwi.crescer.domain.exception.ExceptionMotorista;
//import br.com.cwi.crescer.domain.pessoa.CalculadoraIdade;
//import br.com.cwi.crescer.domain.pessoa.motorista.Motorista;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class TestMotorista {
//
//    @Test
//    public void testaExceptionIdadeMotoristaMenorDe18() {
//        CarteiraHabilitacao carteiraHabilitacao = new CarteiraHabilitacao("23423", Categoria.A);
//        Motorista motorista = new Motorista("Emerson", "emerson@emerson", LocalDate.of(2002, 8, 14), carteiraHabilitacao);
//        assertThrows(ExceptionMotorista.class, () -> {
//            motorista.verificaIdade();
//        });
//        //Assertions.assertEquals(motorista.getCalculadora().calculaIdade(motorista.getDataNascimento()), 16);
//    }
//
//    @Test
//    public void testaExceptionIdadeMotoristaMaiorDe18() {
//        CarteiraHabilitacao carteiraHabilitacao = new CarteiraHabilitacao("23423", Categoria.A);
//        Motorista motorista = new Motorista("Emerson", "emerson@emerson", LocalDate.of(1996, 8, 14), carteiraHabilitacao);
//        Assertions.assertDoesNotThrow(() -> {
//            motorista.verificaIdade();
//        });
//        //Assertions.assertEquals(motorista.getCalculadora().calculaIdade(motorista.getDataNascimento()), 22);
//    }
//
//    @Test
//    public void testaIdadeMotorista() {
//        CarteiraHabilitacao carteira = new CarteiraHabilitacao("123", Categoria.A);
//        Motorista motorista = new Motorista("Rogerinho do ingá", "Rogerinho@rogerinho", LocalDate.of(1997, 10, 25), carteira);
//        CalculadoraIdade idade = new CalculadoraIdade();
//        Assertions.assertEquals(21, idade.calculaIdade(motorista.getDataNascimento()));
//        Assertions.assertNotEquals(23, idade.calculaIdade(motorista.getDataNascimento()));
//    }
//}
