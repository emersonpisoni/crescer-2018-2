package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.PilotoTanque;

import java.time.LocalDate;

public class MilitarPilotoTanque extends Piloto implements PilotoTanque {

    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarPilotoTanque(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual) ==  true && getPilotoTanque()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean getPilotoTanque() {
        return true;
    }
}
