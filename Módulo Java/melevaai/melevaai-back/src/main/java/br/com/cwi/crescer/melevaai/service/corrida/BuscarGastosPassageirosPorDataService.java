package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.domain.dto.CustoPorPassageiroDto;
import br.com.cwi.crescer.melevaai.domain.dto.CustosCorridaDto;
import br.com.cwi.crescer.melevaai.domain.pessoa.passageiro.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import br.com.cwi.crescer.melevaai.service.passageiro.BuscarPassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BuscarGastosPassageirosPorDataService {

    @Autowired
    private CorridaRepository repository;

    public CustoPorPassageiroDto buscar(Long idPassageiro, LocalDateTime data1, LocalDateTime data2) {

        return repository.buscarGastoCorridasPorPassageiro(data1, data2, idPassageiro)
            .orElseThrow(() -> new ExceptionCorrida("Nenhuma corrida encontrada!"));
    }

}
