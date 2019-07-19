package br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos;

import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.Militar;
import br.com.cwi.crescer.aul6.ExercicioArmy.Militares.Piloto;

import java.util.ArrayList;

public abstract class Veiculo {

    protected Piloto piloto;
    protected ArrayList<Militar> tripulacao;
    protected int kmPorLitro;
    protected int precoPorLitro;


    public Veiculo(Piloto pilotoQuePodePilotar, int kmPorLitro, int precoPorLitro, ArrayList<Militar> tripulacao) {
        this.piloto = pilotoQuePodePilotar;
        this.kmPorLitro = kmPorLitro;
        this.precoPorLitro = precoPorLitro;
        this.tripulacao = tripulacao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public abstract boolean tripulacaoValida();

    public int precoTotalDeGasolina(){
        return 0;
    }


}
