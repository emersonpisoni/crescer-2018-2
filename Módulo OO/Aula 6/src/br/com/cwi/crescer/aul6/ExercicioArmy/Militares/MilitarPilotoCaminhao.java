package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.PilotoCaminhao;

import java.time.LocalDate;

public class MilitarPilotoCaminhao extends Piloto implements PilotoCaminhao {

    private LocalDate vencimentoDaLicenca;
    private LocalDate dataAtual;

    public MilitarPilotoCaminhao(int salario, LocalDate localDate) {
        super(salario, localDate);
        vencimentoDaLicenca = localDate;
    }


    @Override
    public boolean verificaLicenca() {
        dataAtual = LocalDate.now();
        if (vencimentoDaLicenca.isAfter(dataAtual) == true && getPilotoCaminhao()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean getPilotoCaminhao() {
        return true;
    }
}
