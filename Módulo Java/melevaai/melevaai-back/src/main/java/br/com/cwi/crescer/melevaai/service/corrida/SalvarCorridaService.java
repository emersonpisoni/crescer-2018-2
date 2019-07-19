package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.corrida.Situacao;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.domain.veiculo.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import br.com.cwi.crescer.melevaai.repository.veiculo.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.passageiro.BuscarPassageiroService;
import br.com.cwi.crescer.melevaai.service.veiculo.BuscarVeiculoRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class SalvarCorridaService {

    @Autowired
    private CorridaRepository repository;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private BuscarVeiculoRandomService buscarVeiculoRandomService;

    public Corrida salvar(Long idPassageiro, Corrida corrida) {

        Passageiro passageiro = buscarPassageiroService.buscar(idPassageiro);

        Veiculo veiculoRandomDisponivel = buscarVeiculoRandomService.buscarVeiculoRandom().get();

        if (corrida.getPontoInicial() == corrida.getPontoFinal()) {
            throw new ExceptionCorrida("Ponto de partida e de chegada iguais, informe valores diferentes!");
        }

        corrida.setTempoPrevisto(tempoRandom());
        corrida.setValorCorrida(BigDecimal.valueOf((corrida.getTempoPrevisto() * 60) * 0.2));
        corrida.setVeiculo(veiculoRandomDisponivel);
        corrida.setPassageiro(passageiro);
        corrida.setVeiculo(veiculoRandomDisponivel);
        corrida.getVeiculo().getMotorista().setOcupado(true);
        corrida.setSituacao(Situacao.CRIADA);

        return repository.save(corrida);
    }

    private int tempoRandom() {
        Random tempo = new Random();
        int tempoRandom = tempo.nextInt((30 - 10) + 1);
        return tempoRandom;
    }

}
