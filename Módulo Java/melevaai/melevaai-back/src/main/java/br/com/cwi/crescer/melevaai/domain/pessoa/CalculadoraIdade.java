package br.com.cwi.crescer.melevaai.domain.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class CalculadoraIdade implements Serializable {

    public int calculaIdade(LocalDate dataNascimento) {

        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();
        return idade;
    }

}
