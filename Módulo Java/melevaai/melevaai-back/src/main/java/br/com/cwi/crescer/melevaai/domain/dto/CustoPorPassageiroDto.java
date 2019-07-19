package br.com.cwi.crescer.melevaai.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CustoPorPassageiroDto {

    String nomePassageiro;
    BigDecimal totalGasto;
}
