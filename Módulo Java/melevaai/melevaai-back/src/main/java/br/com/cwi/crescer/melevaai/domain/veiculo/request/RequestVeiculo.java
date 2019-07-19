package br.com.cwi.crescer.melevaai.domain.veiculo.request;

import br.com.cwi.crescer.melevaai.domain.carteira.Categoria;
import br.com.cwi.crescer.melevaai.domain.pessoa.Dominio;
import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.domain.veiculo.Cor;
import br.com.cwi.crescer.melevaai.domain.veiculo.Marca;
import br.com.cwi.crescer.melevaai.domain.veiculo.VerificaVeiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotoristaNaoHabilitado;
import lombok.Data;

@Data

public class RequestVeiculo extends Dominio{

    private Marca marca;
    private String modelo;
    private int ano;
    private Cor cor;
    private String foto;
    private int quantidadeLugares;
    private Categoria categoria;
    private Long idMotorista;
    private String placa;

}
