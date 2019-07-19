package br.com.cwi.crescer.melevaai.service.corrida;

import br.com.cwi.crescer.melevaai.domain.corrida.Corrida;
import br.com.cwi.crescer.melevaai.exception.ExceptionCorrida;
import br.com.cwi.crescer.melevaai.repository.corrida.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarCorridaService {

    @Autowired
    private CorridaRepository repository;

    public Corrida buscar(final Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ExceptionCorrida("Corrida não encontrada"));
    }

}
