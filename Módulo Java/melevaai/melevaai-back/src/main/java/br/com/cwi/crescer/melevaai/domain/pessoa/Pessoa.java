package br.com.cwi.crescer.melevaai.domain.pessoa;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_PESSOA", initialValue = 1, allocationSize = 1)
public class Pessoa extends Dominio{

    private String nome;
    @Email
    @NonNull
    private String email;
    private LocalDate dataNascimento;
    private BigDecimal Saldo = BigDecimal.valueOf(0);
    private boolean ativo = true;
    private String senha;

    public Perfil getPerfil(){
        return Perfil.ADMINISTRADOR;
    }

}
