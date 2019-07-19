package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.carteira.CarteiraHabilitacao;
import br.com.cwi.crescer.melevaai.domain.carteira.Categoria;
import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import br.com.cwi.crescer.melevaai.service.passageiro.BuscarPassageiroService;
import br.com.cwi.crescer.melevaai.service.veiculo.BuscarVeiculoRandomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class SalvarCorridaServiceTest {

    @InjectMocks

    
    @Mock
    private CorridaRepository repository;

    @Mock
    private BuscarPassageiroService buscarPassageiroService;

    @Mock
    private BuscarVeiculoRandomService buscarVeiculoRandomService;

    private Motorista motoristaValido;

    @BeforeEach
    public void setup() {
        long idadeMotorista = 30;
        long vencimentoHabilitacao = 5;

        LocalDate dataNascimentoMenorMinimo = LocalDate.now().minusYears(idadeMotorista);
        LocalDate dataVencimentoHabilitacao = LocalDate.now().plusYears(vencimentoHabilitacao);

        CarteiraHabilitacao cnh = new CarteiraHabilitacao();
        cnh.setCategoria(Categoria.A);
        cnh.setDataVencimento(LocalDate.of(2020, 8, 14));
        cnh.setNumeroDoDocumento("123");

        motoristaValido = new Motorista();
        motoristaValido.setDataNascimento(LocalDate.of(1996, 8, 14));
        motoristaValido.setEmail("emerson@emerson.com");
        motoristaValido.setNome("Emerson");
        motoristaValido.setCarteiraHabilitacao(cnh);
    }

    @Test
    void testaCriarVeiculo(){
        Motorista motorista = motoristaValido;
    }
}