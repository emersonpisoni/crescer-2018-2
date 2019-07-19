package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.EspecialistaTerrestre;

import java.time.LocalDate;

public class MilitarEspecialistaTerrestre extends Piloto implements EspecialistaTerrestre {

    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarEspecialistaTerrestre(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual)) {
            if (getPilotoCaminhao() && getPilotoTanque()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
    @Override
    public boolean getPilotoCaminhao() {
        return true;
    }

    @Override
    public boolean getPilotoTanque() {
        return true;
    }
}
