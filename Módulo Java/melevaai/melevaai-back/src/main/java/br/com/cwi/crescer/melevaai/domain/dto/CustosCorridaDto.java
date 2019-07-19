package br.com.cwi.crescer.melevaai.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustosCorridaDto {

    private LocalDateTime dataCorrida;
    private String nomeMotorista;
    private String placa;
    private String nomeDoPassageiro;
    private BigDecimal valorCorrida;

}
