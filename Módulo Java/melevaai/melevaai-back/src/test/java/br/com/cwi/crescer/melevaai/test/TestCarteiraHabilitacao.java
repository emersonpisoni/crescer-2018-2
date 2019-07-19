//package br.com.cwi.crescer.test;
//
//import br.com.cwi.crescer.domain.carteira.CarteiraHabilitacao;
//import br.com.cwi.crescer.domain.carteira.Categoria;
//import br.com.cwi.crescer.domain.pessoa.motorista.Motorista;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//class TestCarteiraHabilitacao {
//
//    @Test
//    public void testaCarteiraDeHabilitaçãoA() {
//        CarteiraHabilitacao carteira = new CarteiraHabilitacao("123", Categoria.A);
//        Motorista motorista = new Motorista("Emerson", "Emerson@Emerson", LocalDate.of(1996, 8, 14), carteira);
//        Assertions.assertEquals(Categoria.A, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.B, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.C, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.D, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.E, motorista.getCarteriaHabilitacao().getCategoria());
//    }
//
//    @Test
//    public void testaCarteiraDeHabilitaçãoD() {
//        CarteiraHabilitacao carteira = new CarteiraHabilitacao("12346981", Categoria.D);
//        Motorista motorista = new Motorista("Lucas", "Lucas@Lucas", LocalDate.of(1998, 9, 14), carteira);
//        Assertions.assertEquals(Categoria.D, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.B, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.C, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.A, motorista.getCarteriaHabilitacao().getCategoria());
//        Assertions.assertNotEquals(Categoria.E, motorista.getCarteriaHabilitacao().getCategoria());
//    }
//
//    @Test
//    void getCarteiraDeHabilitacao() {
//        CarteiraHabilitacao carteiraHabilitacao = new CarteiraHabilitacao("23423", Categoria.A);
//        Motorista motorista = new Motorista("Emerson", "emerson@emerson", LocalDate.of(1996, 8, 14), carteiraHabilitacao);
//        Assertions.assertEquals(Categoria.A, motorista.getCarteriaHabilitacao().getCategoria());
//    }
//
//}