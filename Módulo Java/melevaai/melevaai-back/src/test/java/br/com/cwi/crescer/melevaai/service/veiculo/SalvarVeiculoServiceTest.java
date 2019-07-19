package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.carteira.CarteiraHabilitacao;
import br.com.cwi.crescer.melevaai.domain.carteira.Categoria;
import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.domain.veiculo.Cor;
import br.com.cwi.crescer.melevaai.domain.veiculo.Marca;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.domain.veiculo.request.RequestVeiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionVeiculo;
import br.com.cwi.crescer.melevaai.repository.passageiro.PassageiroRepository;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.motorista.BuscarMotoristaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class SalvarVeiculoServiceTest {

    @InjectMocks
    private SalvarVeiculoService service;

    @Mock
    private VeiculoRepository repository;

    @Mock
    private BuscarMotoristaService buscarMotoristaService;

    private Motorista motoristaValido;
    private Motorista motoristaInvalido;
    private Veiculo veiculoEx;
    private RequestVeiculo veiculoRequest;

    @BeforeEach
    public void setup() {
        long idadeMotorista = 30;
        long vencimentoHabilitacao = 5;

        LocalDate dataNascimentoMenorMinimo = LocalDate.now().minusYears(idadeMotorista);
        LocalDate dataVencimentoHabilitacao = LocalDate.now().plusYears(vencimentoHabilitacao);

        CarteiraHabilitacao cnhA = new CarteiraHabilitacao();
        cnhA.setCategoria(Categoria.A);

        CarteiraHabilitacao cnhB = new CarteiraHabilitacao();
        cnhB.setCategoria(Categoria.B);

        motoristaValido = new Motorista();
        motoristaValido.setId(Long.valueOf(1));
        motoristaValido.setCarteiraHabilitacao(cnhA);

        motoristaInvalido = new Motorista();
        motoristaInvalido.setId(Long.valueOf(2));
        motoristaInvalido.setCarteiraHabilitacao(cnhB);

        veiculoEx = new Veiculo();
        veiculoEx.setAno(2000);
        veiculoEx.setCategoria(Categoria.A);
        veiculoEx.setCor(Cor.BRANCO);
        veiculoEx.setFoto("foto");
        veiculoEx.setPlaca("CCC-1424");
        veiculoEx.setMarca(Marca.VOLVO);
        veiculoEx.setModelo("modelo");
        veiculoEx.setQuantidadeLugares(5);

    }

    @Test
    void testaCriarVeiculoComCnhIgualDoMotorista(){

        Veiculo veiculo = veiculoEx;

        Mockito.when(buscarMotoristaService.buscar(1L)).thenReturn(motoristaValido);

//        Mockito.when(repository.save(veiculo)).thenReturn;
        Veiculo novoVeiculo = repository.save(veiculo);

        Assertions.assertEquals(novoVeiculo.getMotorista(), motoristaValido);

    }

    @Test
    void testaCriarVeiculoComCnhDiferenteDoMotorista(){

        Veiculo veiculo = veiculoEx;

        Mockito.when(buscarMotoristaService.buscar(veiculo.getId())).thenReturn(motoristaInvalido);

        Assertions.assertThrows(ExceptionVeiculo.class, () -> {
            service.salvar(veiculo, 1L);
        });

    }
}