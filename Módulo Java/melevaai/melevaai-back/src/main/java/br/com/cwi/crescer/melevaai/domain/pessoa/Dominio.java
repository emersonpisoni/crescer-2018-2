package br.com.cwi.crescer.melevaai.domain.pessoa;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(of = "id")
@Data
@MappedSuperclass
public class Dominio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

}