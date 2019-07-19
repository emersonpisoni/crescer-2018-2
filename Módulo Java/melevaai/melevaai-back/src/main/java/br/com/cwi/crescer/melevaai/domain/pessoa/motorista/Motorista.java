package br.com.cwi.crescer.melevaai.domain.pessoa.motorista;

import br.com.cwi.crescer.melevaai.domain.carteira.CarteiraHabilitacao;
import br.com.cwi.crescer.melevaai.domain.pessoa.Perfil;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotorista;
import br.com.cwi.crescer.melevaai.domain.pessoa.Pessoa;
import br.com.cwi.crescer.melevaai.domain.pessoa.VerificaIdade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
public class Motorista extends Pessoa implements VerificaIdade {

    private static final int IDADE_MINIMA = 18;

    private boolean ocupado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CARTEIRA_HABILITACAO")
    private CarteiraHabilitacao carteiraHabilitacao;

    @Override
    public boolean verificaIdade() throws ExceptionMotorista {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.getDataNascimento(), dataAtual);
        return periodo.getYears() >= IDADE_MINIMA;
    }

    @Override
    public Perfil getPerfil() {
        return Perfil.MOTORISTA;
    }
}
