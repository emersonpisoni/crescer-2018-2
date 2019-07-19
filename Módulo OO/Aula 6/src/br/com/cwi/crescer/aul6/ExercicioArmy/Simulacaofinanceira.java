package br.com.cwi.crescer.aul6.ExercicioArmy;

import br.com.cwi.crescer.aul6.ExercicioArmy.Veiculos.Veiculo;

import java.util.List;

public class Simulacaofinanceira {

    private int distanciaDaViagem;
    private int duracaoDaMissao;
    private List<Veiculo> veiculosNaMissao;

    public Simulacaofinanceira(int distanciaDaViagem, int duracaoDaMissao, List<Veiculo> veiculosNaMissao) {
        this.distanciaDaViagem = distanciaDaViagem;
        this.duracaoDaMissao = duracaoDaMissao;
        this.veiculosNaMissao = veiculosNaMissao;
    }

    public int getCustoTotalMissao(){
        return 0;

    }

}
