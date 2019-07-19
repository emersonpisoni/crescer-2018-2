//package br.com.cwi.crescer.test;
//
//import br.com.cwi.crescer.domain.exception.ExceptionPassageiro;
//import br.com.cwi.crescer.domain.pessoa.CalculadoraIdade;
//import br.com.cwi.crescer.domain.pessoa.passageiro.Passageiro;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//public class TestPassageiro {
//
//    @Test
//    public void testaExceptionIdadePassageiroMenorDe18() {
//        Passageiro passageiro = new Passageiro("Emerson", "emerson@emerson", LocalDate.of(2008, 8, 14));
//        Assertions.assertThrows(ExceptionPassageiro.class, () -> {
//            passageiro.verificaIdade();
//        });
//        Assertions.assertEquals(passageiro.getCalculadora().calculaIdade(passageiro.getDataNascimento()), 10);
//    }
//
//    @Test
//    public void testaExceptionIdadePassageiroMaiorDe18() {
//        Passageiro passageiro = new Passageiro("Emerson", "emerson@emerson", LocalDate.of(1996, 8, 14));
//        Assertions.assertDoesNotThrow(() -> {
//            passageiro.verificaIdade();
//        });
//        Assertions.assertEquals(passageiro.getCalculadora().calculaIdade(passageiro.getDataNascimento()), 22);
//    }
//
//    @Test
//    public void testaIdadePassageiro() {
//        Passageiro passageiro = new Passageiro("Emerson", "Emerson", LocalDate.of(1996, 8, 14));
//        CalculadoraIdade idade = new CalculadoraIdade();
//        Assertions.assertEquals(22, idade.calculaIdade(passageiro.getDataNascimento()));
//        Assertions.assertNotEquals(25, idade.calculaIdade(passageiro.getDataNascimento()));
//    }
//}
