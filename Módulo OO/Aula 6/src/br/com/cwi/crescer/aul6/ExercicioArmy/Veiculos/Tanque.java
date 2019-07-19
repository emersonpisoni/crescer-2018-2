package br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.*;

import java.util.ArrayList;

public class Tanque extends Veiculo {

    MilitarPilotoTanque militarPilotoTanque;

    public Tanque(MilitarElite pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Tanque(MilitarEspecialistaTerrestre pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Tanque(MilitarPilotoTanque pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    @Override
    public boolean tripulacaoValida() {
        if (militarPilotoTanque != null && tripulacao.size() == 3 && super.piloto.verificaLicenca()) {
            return true;
        } else {
            return false;
        }
    }
}
