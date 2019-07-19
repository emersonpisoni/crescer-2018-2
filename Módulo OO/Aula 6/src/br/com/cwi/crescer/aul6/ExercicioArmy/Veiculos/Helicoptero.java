package br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.*;

import java.util.ArrayList;

public class Helicoptero extends Veiculo {

    MilitarPilotoHelicoptero militarPilotoHelicoptero;

    public Helicoptero(MilitarElite pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Helicoptero(MilitarEspecialistaDoAr pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Helicoptero(MilitarPilotoHelicoptero pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    @Override
    public boolean tripulacaoValida() {
        if ((tripulacao.size() <= 10 && tripulacao.size() >= 0) && super.piloto.verificaLicenca()) {
            return true;
        } else {
            return false;
        }
    }
}
