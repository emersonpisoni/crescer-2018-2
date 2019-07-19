package test.br.com.cwi.crescer.aul6;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.*;
import br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos.Aviao;
import br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos.Caminhao;
import br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos.Helicoptero;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void tripulacaoValida() {


    }

    @Test
    void testaTropaCaminhao(){
        LocalDate localDate = LocalDate.of(2019,12,12);

        MilitarPilotoCaminhao militarPilotoCaminhao = new MilitarPilotoCaminhao(1000, localDate);

        ArrayList<Militar> tripulacao = new ArrayList<>();

        MilitarComum militar = new MilitarComum(1000);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);

        Caminhao caminhao = new Caminhao(militarPilotoCaminhao, 10, 3, tripulacao);


        assertTrue(caminhao.tripulacaoValida(), "true");
    }

    @Test
    void testaTropaAviao(){
        LocalDate localDate = LocalDate.of(2019,12,12);

        MilitarPilotoAviao militarPilotoAviao = new MilitarPilotoAviao(31000, localDate);

        ArrayList<Militar> tripulacao = new ArrayList<>();

        MilitarComum militar = new MilitarComum(1000);
        tripulacao.add(militar);


        Aviao aviao = new Aviao(militarPilotoAviao, 10, 3, tripulacao);

        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);

        assertEquals(aviao.tripulacaoValida(), false);

    }

    @Test
    void testaTropaHelicoptero(){
        LocalDate localDate = LocalDate.of(2019,12,12);

        MilitarPilotoHelicoptero militarPilotoHelicoptero = new MilitarPilotoHelicoptero(31000, localDate);

        ArrayList<Militar> tripulacao = new ArrayList<>();

        MilitarComum militar = new MilitarComum(1000);

        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);
        tripulacao.add(militar);


        Helicoptero helicoptero = new Helicoptero(militarPilotoHelicoptero, 10, 3, tripulacao);



        assertNotNull(helicoptero.tripulacaoValida(), String.valueOf(false));


    }
}