package br.com.cwi.crescer.melevaai.domain.veiculo;

import br.com.cwi.crescer.melevaai.domain.carteira.Categoria;
import br.com.cwi.crescer.melevaai.exception.ExceptionMotoristaNaoHabilitado;
import br.com.cwi.crescer.melevaai.domain.pessoa.Dominio;
import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_VEICULO", initialValue = 1, allocationSize = 1)
public class Veiculo extends Dominio implements VerificaVeiculo {

    @Enumerated(EnumType.STRING)
    private Marca marca;
    private String modelo;
    private int ano;
    @Enumerated(EnumType.STRING)
    private Cor cor;
    private String foto;
    private int quantidadeLugares;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String placa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MOTORISTA")
    private Motorista motorista;

    @Override
    public void verificaVeiculo() throws ExceptionMotoristaNaoHabilitado {
        Categoria categoriaMotorista = motorista.getCarteiraHabilitacao().getCategoria();
        if(categoriaMotorista == this.categoria){
            return;
        }else if(categoriaMotorista == Categoria.A && this.categoria == Categoria.ACC){
            return;
        }else if(categoriaMotorista == Categoria.C && this.categoria == Categoria.B){
            return;
        }else if(categoriaMotorista == Categoria.D && (this.categoria == Categoria.B || this.categoria == Categoria.C)){
            return;
        }else if(categoriaMotorista == Categoria.E && (this.categoria == Categoria.B || this.categoria == Categoria.C || this.categoria == Categoria.D)){
            return;
        }else{
            throw new ExceptionMotoristaNaoHabilitado();
        }
    }
}
