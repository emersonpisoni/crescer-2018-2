package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.EspecialistaDoAr;

import java.time.LocalDate;

public class MilitarEspecialistaDoAr extends Piloto implements EspecialistaDoAr {


    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarEspecialistaDoAr(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual)) {
            if (getPilotoAviao() && getPilotoHelicoptero()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean getPilotoAviao() {
        return true;
    }

    @Override
    public boolean getPilotoHelicoptero() {
        return true;
    }
}
