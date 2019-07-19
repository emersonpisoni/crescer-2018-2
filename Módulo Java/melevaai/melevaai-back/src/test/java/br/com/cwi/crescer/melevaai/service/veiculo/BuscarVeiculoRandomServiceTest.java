package br.com.cwi.crescer.melevaai.service.veiculo;

import br.com.cwi.crescer.melevaai.domain.pessoa.motorista.Motorista;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.exception.ExceptionVeiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BuscarVeiculoRandomServiceTest {

    @InjectMocks
    private BuscarVeiculoRandomService service;

    @Mock
    private BuscarTodosVeiculosService buscarTodosVeiculosService;

    @Test
    void buscarVeiculoRandom() {
        Motorista motorista = new Motorista();

        List<Veiculo> veiculoList = new ArrayList<>();
        Veiculo veiculo = new Veiculo();
        veiculo.setMotorista(motorista);
        veiculoList.add(veiculo);

//        Mockito.when(buscarTodosVeiculosService.buscarVeiculos()).thenReturn(veiculoList);

        Veiculo veiculoDaLista = service.buscarVeiculoRandom().get();

        Assertions.assertEquals(veiculo, veiculoDaLista);
    }

    @Test
    void buscarVeiculoRandomIndisponível() {
        Motorista motorista = new Motorista();
        motorista.setOcupado(true);

        List<Veiculo> veiculoList = new ArrayList<>();
        Veiculo veiculo = new Veiculo();
        veiculo.setMotorista(motorista);
        veiculoList.add(veiculo);

//        Mockito.when(buscarTodosVeiculosService.buscarVeiculos()).thenReturn(veiculoList);

        Assertions.assertThrows(ExceptionCorrida.class, () -> {
            service.buscarVeiculoRandom();
        });

    }
}