package br.com.cwi.crescer.melevaai.domain.corrida;

import br.com.cwi.crescer.melevaai.domain.pessoa.Dominio;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_CORRIDA", initialValue = 1, allocationSize = 1)
public class Corrida extends Dominio {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_VEICULO")
    private Veiculo veiculo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PASSAGEIRO")
    private Passageiro passageiro;
    private Long pontoInicial;
    private Long pontoFinal;
    private BigDecimal valorCorrida;
    private int tempoPrevisto;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dataHoraInicio;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dataHoraFinal;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    private int notaMotorista;
    private int notaPassageiro;

}
