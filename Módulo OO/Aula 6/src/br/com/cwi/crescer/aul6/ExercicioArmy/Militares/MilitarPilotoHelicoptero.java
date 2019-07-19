package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.PilotoHelicoptero;

import java.time.LocalDate;

public class MilitarPilotoHelicoptero extends Piloto implements PilotoHelicoptero {
    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarPilotoHelicoptero(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual) == true && getPilotoHelicoptero()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getPilotoHelicoptero() {
        return true;
    }
}
