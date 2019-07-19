package br.com.cwi.crescer.melevaai.domain.pessoa.passageiro;

import br.com.cwi.crescer.melevaai.domain.pessoa.Perfil;
import br.com.cwi.crescer.melevaai.exception.ExceptionPassageiro;
import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.domain.pessoa.VerificaIdade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
public class Passageiro extends Pessoa implements VerificaIdade {

    private static final int IDADE_MINIMA = 16;

    @Override
    public boolean verificaIdade() throws ExceptionPassageiro {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.getDataNascimento(), dataAtual);
        return periodo.getYears() >= IDADE_MINIMA;
    }

    @Override
    public Perfil getPerfil() {
        return Perfil.PASSAGEIRO;
    }
}

