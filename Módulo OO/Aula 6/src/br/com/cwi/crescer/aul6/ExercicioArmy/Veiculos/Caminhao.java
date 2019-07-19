package br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.*;

import java.util.ArrayList;

public class Caminhao extends Veiculo {

    MilitarPilotoCaminhao militarPilotoCaminhao;

    public Caminhao(MilitarEspecialistaTerrestre pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Caminhao(MilitarPilotoCaminhao pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    public Caminhao(MilitarElite pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);
    }

    @Override
    public boolean tripulacaoValida() {
        if (piloto != null && tripulacao.size() >= 5 && tripulacao.size() <= 30 && super.piloto.verificaLicenca()) {
            return true;
        } else {
            return false;
        }
    }
}
