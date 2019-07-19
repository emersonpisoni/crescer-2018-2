package br.com.cwi.crescer.aula5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormacaoTest {

    @Test
    void getDanoTotalDaFormacao() {
        Formacao formacao = new Formacao();
        Ariete ariete = new Ariete("ariete", 50);
        ArieteComPontaDeFerro arieteComPontaDeFerro = new ArieteComPontaDeFerro("arieteDeFerro", 100);
        Catapulta catapulta = new Catapulta("catapa", 200, 2);
        formacao.posicionarArma(ariete);
        formacao.posicionarArma(arieteComPontaDeFerro);
        formacao.posicionarArma(catapulta);
        assertEquals(454, formacao.getDanoTotalDaFormacao());
    }
}