package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.corrida.Situacao;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FinalizarCorridaService {

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private CorridaRepository repository;

    public Corrida finalizar(Long idCorrida){

        Corrida corridaEmAndamento = buscarCorridaService.buscar(idCorrida);

        if (corridaEmAndamento.getSituacao() == Situacao.CRIADA) {
            throw new ExceptionCorrida("Corrida ainda não está iniciada, você deve iniciá-la para poder finalizar");
        }
        if (corridaEmAndamento.getSituacao() == Situacao.FINALIZADA) {
            throw new ExceptionCorrida("Corrida já foi finalizada");
        }
        if (corridaEmAndamento.getPassageiro().getSaldo().compareTo(corridaEmAndamento.getValorCorrida()) < 0) {
            throw new ExceptionCorrida("Saldo do passageiro insuficiente, deposite na sua conta para poder finalizar");
        }

        corridaEmAndamento.getPassageiro().setSaldo(corridaEmAndamento.getPassageiro().getSaldo().subtract(corridaEmAndamento.getValorCorrida()));
        corridaEmAndamento.getVeiculo().getMotorista().setSaldo(corridaEmAndamento.getVeiculo().getMotorista().getSaldo().add(corridaEmAndamento.getValorCorrida()));
        corridaEmAndamento.setDataHoraFinal(LocalDateTime.now());
        corridaEmAndamento.setSituacao(Situacao.FINALIZADA);
        corridaEmAndamento.getVeiculo().getMotorista().setOcupado(false);

        return repository.save(corridaEmAndamento);

    }
}
