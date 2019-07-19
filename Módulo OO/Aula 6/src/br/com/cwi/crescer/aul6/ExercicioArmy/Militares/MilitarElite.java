package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.Elite;

import java.time.LocalDate;

public class MilitarElite extends Piloto implements Elite {

    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarElite(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual)) {
            if (getPilotoAviao() && getPilotoCaminhao() && getPilotoHelicoptero() && getPilotoTanque()) {
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
    public boolean getPilotoCaminhao() {
        return true;
    }

    @Override
    public boolean getPilotoHelicoptero() {
        return true;
    }

    @Override
    public boolean getPilotoTanque() {
        return true;
    }
}
