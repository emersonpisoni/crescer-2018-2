package test.br.com.cwi.crescer.aul6;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.Militar;
import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.MilitarPilotoAviao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PilotoTest {

    @Test
    void verificaLicencaVencidaENaoVencida(){
        LocalDate localDate = LocalDate.of(2018,12,12);
        MilitarPilotoAviao militarPilotoAviao = new MilitarPilotoAviao(1000, localDate);

        militarPilotoAviao.verificaLicenca();

        assertEquals(true, militarPilotoAviao.verificaLicenca());

        LocalDate localDateVencida = LocalDate.of(2017,12,12);

        MilitarPilotoAviao militarPilotoAviao1 = new MilitarPilotoAviao(1000,localDateVencida);

        militarPilotoAviao.verificaLicenca();

        assertNotEquals(true, militarPilotoAviao1.verificaLicenca());
    }
}