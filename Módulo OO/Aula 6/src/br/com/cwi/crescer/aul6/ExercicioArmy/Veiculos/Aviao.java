package br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos;

import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.EspecialistaDoAr;
import br.com.cwi.crescer.aul6.ExercicioArmy.Habilidades.PilotoAviao;
import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.*;

import java.util.ArrayList;

public class Aviao extends Veiculo implements PilotoAviao {

    public Aviao(MilitarPilotoAviao pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);

    }
    public Aviao(MilitarElite pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);

    }
    public Aviao(MilitarEspecialistaDoAr pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        super(pilotoQuePodePilotar, kmPorLitro, precoPorLitro, tripulacao);

    }

    public boolean tripulacaoValida() {
        if ((tripulacao.size() == 0 || tripulacao.size() == 1) && super.piloto.verificaLicenca()) {
                return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean getPilotoAviao() {
        return false;
    }

}
