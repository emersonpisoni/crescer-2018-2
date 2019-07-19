package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.PilotoAviao;

import java.time.LocalDate;

public class MilitarPilotoAviao extends Piloto implements PilotoAviao {

    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarPilotoAviao(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }

    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual) == true && getPilotoAviao()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getPilotoAviao() {
        return true;
    }
}
