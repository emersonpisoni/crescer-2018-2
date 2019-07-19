package br.com.cwi.crescer.aul6.ExercicioArmy.Militares;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.EspecialistaDoAr;

import java.time.LocalDate;

public abstract class Piloto extends Militar implements EspecialistaDoAr {


    private LocalDate vencimentoDaLicenca;

    public Piloto(int salario, LocalDate localDate) {
        super(salario);
        vencimentoDaLicenca = localDate;
    }

    public abstract boolean verificaLicenca();

    @Override
    public boolean getPilotoAviao() {
        return false;
    }

    @Override
    public boolean getPilotoHelicoptero() {
        return false;
    }
}
