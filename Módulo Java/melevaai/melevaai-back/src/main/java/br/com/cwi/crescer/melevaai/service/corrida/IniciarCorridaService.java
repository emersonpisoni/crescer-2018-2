package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.corrida.Situacao;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IniciarCorridaService {

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private CorridaRepository repository;

    public String[] iniciar(Long idCorrida) {

        Corrida corrida = buscarCorridaService.buscar(idCorrida);

        if (corrida.getSituacao() == Situacao.EM_AMDAMENTO) {

            throw new ExceptionCorrida("Corrida já foi iniciada");

        } else if (corrida.getSituacao() == Situacao.FINALIZADA) {

            throw new ExceptionCorrida("Corrida já foi finalizada");

        }

        corrida.setDataHoraInicio(LocalDateTime.now());
        corrida.setSituacao(Situacao.EM_AMDAMENTO);

        String[] iniciarCorridaDados = new String[]{corrida.getTempoPrevisto() + " min", "R$: " + corrida.getValorCorrida()};

        repository.save(corrida);

        return iniciarCorridaDados;

    }
}
